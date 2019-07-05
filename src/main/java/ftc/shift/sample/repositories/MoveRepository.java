package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Move;
import java.util.Collection;

public interface MoveRepository {
    Move fetchMove(String userId, String travelId, String moveId);

    Move updateMove(String userId, String travelId, String moveId, Move move);

    void deleteMove(String userId, String travelId, String moveId);

    Move createMove(String userId, String travelId, Move move);

    Collection<Move> getAllMoves(String userId, String travelId);
}
