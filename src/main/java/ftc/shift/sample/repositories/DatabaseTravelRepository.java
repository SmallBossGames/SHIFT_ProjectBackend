package ftc.shift.sample.repositories;

import ftc.shift.sample.exception.ConflictException;
import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.Travel;
import ftc.shift.sample.models.Move;
import ftc.shift.sample.repositories.extractors.TravelExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Repository
@ConditionalOnProperty(name = "use.database", havingValue = "true")
public class DatabaseTravelRepository implements TravelRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final TravelExtractor extractor;

    @Autowired
    public DatabaseTravelRepository(NamedParameterJdbcTemplate jdbcTemplate, TravelExtractor extractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
    }

    @Override
    public Travel fetchTravel(String userId, String travelId) {
        var sql = "SELECT ID, NAME FROM TRAVELS WHERE USER_ID = :userId AND ID = :travelId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelId", travelId);
        var result = jdbcTemplate.query(sql, params, extractor);

        if(result.isEmpty())
        {
            throw new NotFoundException();
        }

        return result.get(0);
    }

    @Override
    public Travel updateTravel(String userId, String travelId, Travel travel) {
        if(!Objects.equals(travel.getId(), travelId))
        {
            throw new ConflictException();
        }

        var sql = "UPDATE TRAVELS SET NAME=:name WHERE ID=:travelId AND USER_ID=:userId;";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("name", travel.getName())
                .addValue("travelId", travelId);
        jdbcTemplate.update(sql, params);
        return travel;
    }

    @Override
    public void deleteTravel(String userId, String travelId) {
        final var sql = "DELETE FROM TRAVELS WHERE ID = :travelId AND USER_ID = :userId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelId", travelId);
        jdbcTemplate.update(sql, params);
    }

    @Override
    public Travel createTravel(String userId, Travel travel) {
        var sql = "INSERT INTO TRAVELS (USER_ID, NAME) VALUES (:userId, :name)";

        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("name", travel.getName());

        var keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sql, params, keyHolder);

        var travelId = keyHolder.getKeys().get("ID").toString();
        travel.setId(travelId);

        return travel;
    }

    @Override
    public Collection<Travel> getAllTravels(String userId) {
        var sql = "SELECT TRAVELS.ID, TRAVELS.NAME FROM TRAVELS WHERE TRAVELS.USER_ID = :userId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId);
        return jdbcTemplate.query(sql, params, extractor);
    }
}
