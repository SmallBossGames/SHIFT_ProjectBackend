package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Move;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Repository
public class DatabaseMoveRepository implements MoveRepository {
    @Override
    public Move fetchMove(String userId, String travelId, String moveId) {
        var temp = new Move(
                "foweiowfe",
                "fwieoiqwfo",
                "from",
                new Date(),
                "to",
                new Date(),
                45.0,
                1,
                new BigDecimal(34)
        );
        return temp;
    }

    @Override
    public Move updateMove(String userId, String travelId, String moveId, Move move) {
        return move;
    }

    @Override
    public void deleteMove(String userId, String travelId, String moveId) {
        return;
    }

    @Override
    public Move createMove(String userId, String travelId, Move move) {
        return move;
    }

    @Override
    public Collection<Move> getAllMoves(String userId, String travelId) {
        var temp = new Move(
                "foweiowfe",
                "fwieoiqwfo",
                "from",
                new Date(),
                "to",
                new Date(),
                45.0,
                1,
                new BigDecimal(34)
        );
        var tempCollection = new ArrayList<Move>();
        tempCollection.add(temp);
        return tempCollection;
    }
}
