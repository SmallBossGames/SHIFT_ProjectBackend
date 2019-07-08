package ftc.shift.sample.repositories;

import ftc.shift.sample.exception.BadRequestException;
import ftc.shift.sample.exception.ConflictException;
import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.Move;
import ftc.shift.sample.repositories.extractors.MoveExtractor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Repository
public class DatabaseMoveRepository implements MoveRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final MoveExtractor extractor;

    public DatabaseMoveRepository(NamedParameterJdbcTemplate jdbcTemplate, MoveExtractor extractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
    }

    @Override
    public Move fetchMove(String userId, String travelId, String moveId) {
        var sql = "SELECT ID, TRANSFER_ID, FROM_PLACE, TO_PLACE, FROM_DATE, TO_DATE, DISTANCE, MONEY\n" +
                "FROM MOVES\n" +
                "WHERE TRAVEL_ID = :travelId AND ID = :moveId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelId", travelId)
                .addValue("moveId", moveId);

        var result = jdbcTemplate.query(sql, params, extractor);

        if(result.isEmpty())
        {
            throw new NotFoundException();
        }

        return result.get(0);
    }

    @Override
    public Collection<Move> getAllMoves(String userId, String travelId) {
        var sql = "SELECT ID, TRANSFER_ID, FROM_PLACE, TO_PLACE, FROM_DATE, TO_DATE, DISTANCE, MONEY\n" +
                "FROM MOVES\n" +
                "WHERE TRAVEL_ID = :travelId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelId", travelId);
        return jdbcTemplate.query(sql, params, extractor);
    }

    @Override
    public Move createMove(String userId, String travelId, Move move) {
        var sql = "INSERT INTO MOVES (TRAVEL_ID, TRANSFER_ID, FROM_PLACE, TO_PLACE, FROM_DATE, TO_DATE, DISTANCE, MONEY)\n" +
                "VALUES (:travelId, :transferId, :fromPlace, :toPlace, :fromDate, :toDate, :distance, :money);";
        var params = new MapSqlParameterSource()
                .addValue("travelId", travelId)
                .addValue("transferId", move.getTransferId())
                .addValue("fromPlace", move.getFromPlace())
                .addValue("toPlace", move.getToPlace())
                .addValue("fromDate", move.getFromDate())
                .addValue("toDate", move.getToDate())
                .addValue("distance", move.getDistance())
                .addValue("money", move.getMoney());
        var keyHolder = new GeneratedKeyHolder();

        try
        {
            jdbcTemplate.update(sql, params, keyHolder);
        }
        catch (DataAccessException ex)
        {
            throw new BadRequestException();
        }

        var moveId = keyHolder.getKeys().get("ID").toString();

        return fetchMove(userId, travelId, moveId);
    }

    @Override
    public Move updateMove(String userId, String travelId, String moveId, Move move) {
        if(!Objects.equals(moveId, move.getId())){
            throw new ConflictException();
        }

        var sql = "UPDATE MOVES SET TRAVEL_ID = :travelId, \n" +
                "TRANSFER_ID = :transferId, FROM_PLACE = :fromPlace, \n" +
                "TO_PLACE = :toPlace, FROM_DATE = :fromDate, \n" +
                "TO_DATE = :toDate, DISTANCE = :distance, MONEY = :money\n" +
                "WHERE ID = :moveId AND TRAVEL_ID = :travelId;";

        var params = new MapSqlParameterSource()
                .addValue("moveId", moveId)
                .addValue("travelId", travelId)
                .addValue("transferId", move.getTransferId())
                .addValue("fromPlace", move.getFromPlace())
                .addValue("toPlace", move.getToPlace())
                .addValue("fromDate", move.getFromDate())
                .addValue("toDate", move.getToDate())
                .addValue("distance", move.getDistance())
                .addValue("money", move.getMoney());

        try
        {
            jdbcTemplate.update(sql, params);
        }
        catch (DataAccessException ex)
        {
            throw new BadRequestException();
        }

        return fetchMove(userId, travelId, moveId);
    }

    @Override
    public void deleteMove(String userId, String travelId, String moveId) {
        var sql = "DELETE FROM MOVES WHERE ID = :moveId AND TRAVEL_ID = :travelId";
        var params = new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("travelId", travelId)
                .addValue("moveId", moveId);
        jdbcTemplate.update(sql, params);
    }

}
