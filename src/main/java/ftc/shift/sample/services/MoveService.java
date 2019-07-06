package ftc.shift.sample.services;

import ftc.shift.sample.models.Move;
import ftc.shift.sample.repositories.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MoveService {
    private final MoveRepository moveRepository;

    @Autowired
    public MoveService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public Move provideMove(String userId, String travelId, String moveId) {
        return moveRepository.fetchMove(userId, travelId, moveId);
    }

    public Move updateMove(String userId, String travelId, String moveId, Move move) {
        return moveRepository.updateMove(userId, travelId, moveId, move);
    }

    public void deleteMove(String userId, String travelId, String moveId) {
        moveRepository.deleteMove(userId, travelId, moveId);
    }

    public Move createMove(String userId, String travelId, Move move) {
        return moveRepository.createMove(userId, travelId, move);
    }

    public Collection<Move> provideMoves(String userId, String travelId) {
        return moveRepository.getAllMoves(userId, travelId);
    }
}
