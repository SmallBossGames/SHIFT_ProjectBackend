package ftc.shift.sample.repositories;

import ftc.shift.sample.exception.BadRequestException;
import ftc.shift.sample.exception.ConflictException;
import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.MoveNote;
import ftc.shift.sample.repositories.extractors.MoveNoteExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Objects;

@Repository
public class DatabaseMoveNoteRepository implements MoveNoteRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MoveNoteExtractor extractor;

    @Autowired
    public DatabaseMoveNoteRepository(NamedParameterJdbcTemplate jdbcTemplate, MoveNoteExtractor extractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
    }

    @Override
    public MoveNote fetchMoveNote(String userId, String moveId, String moveNoteId) {
        var sql = "SELECT ID, TITLE, TEXT\n" +
                "FROM MOVE_NOTES\n" +
                "WHERE ID = :moveNoteId\n" +
                "AND MOVE_ID = :moveId";
        var params = new MapSqlParameterSource()
                .addValue("moveNoteId", moveNoteId)
                .addValue("moveId", moveId);
        var result = jdbcTemplate.query(sql, params, extractor);

        if(result.isEmpty())
        {
            throw new NotFoundException();
        }

        return result.get(0);
    }

    @Override
    public MoveNote updateMoveNote(String userId, String moveId, String moveNoteId, MoveNote moveNote) {
        if(!Objects.equals(moveNoteId, moveNote.getId())){
            throw new ConflictException();
        }

        var sql = "UPDATE MOVE_NOTES SET TITLE = :title, TEXT = :text \n" +
                "WHERE ID=:moveNoteId AND MOVE_ID=:moveId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("moveId", moveId)
                .addValue("moveNoteId", moveNoteId)
                .addValue("title", moveNote.getTitle())
                .addValue("text", moveNote.getText());
        try
        {
            jdbcTemplate.update(sql, params);
        }
        catch (DataAccessException ex)
        {
            throw new BadRequestException();
        }

        return fetchMoveNote(userId, moveId, moveNoteId);
    }

    @Override
    public void deleteMoveNote(String userId, String moveId, String moveNoteId) {
        var sql = "DELETE FROM MOVE_NOTES WHERE ID = :moveNoteId AND MOVE_ID = :moveId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("moveId", moveId)
                .addValue("moveNoteId", moveNoteId);
        jdbcTemplate.update(sql, params);
    }

    @Override
    public MoveNote createMoveNote(String userId, String moveId, MoveNote moveNote) {
        var sql = "INSERT INTO MOVE_NOTES (MOVE_ID, TITLE, TEXT) \n" +
                "VALUES (:moveId, :title, :text)";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("moveId", moveId)
                .addValue("title", moveNote.getTitle())
                .addValue("text", moveNote.getText());
        var keyHolder = new GeneratedKeyHolder();

        try
        {
            jdbcTemplate.update(sql, params, keyHolder);
        }
        catch (DataAccessException ex)
        {
            throw new BadRequestException();
        }

        var moveNoteId = keyHolder.getKeys().get("ID").toString();

        return fetchMoveNote(userId, moveId, moveNoteId);
    }

    @Override
    public Collection<MoveNote> getAllMoveNotes(String userId, String moveId) {
        var sql = "SELECT ID, TITLE, TEXT\n" +
                "FROM MOVE_NOTES\n" +
                "WHERE MOVE_ID = :moveId";
        var params = new MapSqlParameterSource()
                .addValue("moveId", moveId);
        return jdbcTemplate.query(sql, params, extractor);
    }
}
