package ftc.shift.sample.repositories;

import ftc.shift.sample.exception.BadRequestException;
import ftc.shift.sample.exception.ConflictException;
import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.TravelNote;
import ftc.shift.sample.repositories.extractors.TravelNoteExtractor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Repository
public class DatabaseTravelNoteRepository implements TravelNoteRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final TravelNoteExtractor extractor;

    public DatabaseTravelNoteRepository(NamedParameterJdbcTemplate jdbcTemplate, TravelNoteExtractor extractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
    }

    @Override
    public TravelNote fetchTravelNote(String userId, String travelId, String travelNoteId) {
        var sql = "SELECT TRAVEL_NOTES.ID, TRAVEL_NOTES.TITLE, TRAVEL_NOTES.TEXT\n" +
                "FROM TRAVEL_NOTES, TRAVELS\n" +
                "WHERE TRAVEL_NOTES.ID = :travelNoteId\n" +
                "AND TRAVELS.ID = :travelId\n" +
                "AND TRAVELS.USER_ID = :userId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelId", travelId)
                .addValue("travelNoteId", travelNoteId);
        var result = jdbcTemplate.query(sql, params, extractor);

        if(result.isEmpty())
        {
            throw new NotFoundException();
        }

        return result.get(0);
    }

    @Override
    public Collection<TravelNote> getAllTravelNotes(String userId, String travelId) {
        var sql = "SELECT TRAVEL_NOTES.ID, TRAVEL_NOTES.TITLE, TRAVEL_NOTES.TEXT  \n" +
                "FROM TRAVEL_NOTES, TRAVELS \n" +
                "WHERE TRAVELS.ID = :travelId\n" +
                "AND TRAVELS.USER_ID = :userId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelId", travelId);
        return jdbcTemplate.query(sql, params, extractor);
    }

    @Override
    public TravelNote updateTravelNote(String userId, String travelId, String travelNoteId, TravelNote travelNote) {
        if(!Objects.equals(travelNoteId, travelNote.getId())){
            throw new ConflictException();
        }

        var sql = "UPDATE TRAVEL_NOTES SET TITLE = :title, TEXT = :text \n" +
                "WHERE ID=:travelNoteId AND TRAVEL_ID=:travelId;";

        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelNoteId", travelNoteId)
                .addValue("travelId", travelId)
                .addValue("title", travelNote.getTitle())
                .addValue("text", travelNote.getText());

        try
        {
            jdbcTemplate.update(sql, params);
        }
        catch (DataAccessException ex)
        {
            throw new BadRequestException();
        }

        return fetchTravelNote(userId, travelId, travelNoteId);
    }

    @Override
    public void deleteTravelNote(String userId, String travelId, String travelNoteId) {
        var sql = "DELETE FROM TRAVEL_NOTES WHERE ID = :travelNoteId AND TRAVEL_ID = :travelId";
        var params = new MapSqlParameterSource()
                .addValue("travelNoteId", travelNoteId)
                .addValue("travelId", travelId);
        jdbcTemplate.update(sql, params);
    }

    @Override
    public TravelNote createTravelNote(String userId, String travelId, TravelNote travelNote) {
        var sql = "INSERT INTO TRAVEL_NOTES (TRAVEL_ID, TITLE, TEXT)\n" +
                "VALUES (:travelId, :title, :text)";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelId", travelId)
                .addValue("title", travelNote.getTitle())
                .addValue("text", travelNote.getText());
        var keyHolder = new GeneratedKeyHolder();

        try
        {
            jdbcTemplate.update(sql, params, keyHolder);
        }
        catch (DataAccessException ex)
        {
            throw new BadRequestException();
        }


        var travelNoteId = keyHolder.getKeys().get("ID").toString();

        return fetchTravelNote(userId, travelId, travelNoteId);
    }


}
