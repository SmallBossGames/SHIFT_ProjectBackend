package ftc.shift.sample.repositories.extractors;

import ftc.shift.sample.models.Move;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MoveExtractor implements ResultSetExtractor<List<Move>> {
    @Override
    public List<Move> extractData(ResultSet rs) throws SQLException, DataAccessException {
        var moves = new HashMap<String, Move>();
        while (rs.next())
        {
            String id = rs.getString("ID");
            if(!moves.containsKey(id))
            {
                var move = new Move();

                move.setId(rs.getString("ID"));
                move.setTransferId(rs.getInt("TRANSFER_ID"));
                move.setFromPlace(rs.getString("FROM_PLACE"));
                move.setToPlace(rs.getString("TO_PLACE"));
                move.setFromDate(rs.getDate("FROM_DATE"));
                move.setToDate(rs.getDate("TO_DATE"));
                move.setDistance(rs.getDouble("DISTANCE"));
                move.setMoney(rs.getBigDecimal("MONEY"));

                moves.put(id, move);
            }
        }
        return new ArrayList<>(moves.values());
    }
}