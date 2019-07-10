package ftc.shift.sample.repositories;

import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.FinalPrice;
import ftc.shift.sample.repositories.extractors.FinalPriceExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseFinalPriceRepository implements FinalPriceRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final FinalPriceExtractor extractor;

    @Autowired
    public DatabaseFinalPriceRepository(NamedParameterJdbcTemplate jdbcTemplate, FinalPriceExtractor extractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
    }

    @Override
    public FinalPrice fetchFinalPrice(String userId, String travelId) {
        var sql = "SELECT * FROM FINAL_PRICES_VIEW \n" +
                "WHERE TRAVEL_ID = :travelId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelId", travelId);
        var result = jdbcTemplate.query(sql,params, extractor);

        if(result.isEmpty())
        {
            throw new NotFoundException();
        }

        return result.get(0);
    }
}
