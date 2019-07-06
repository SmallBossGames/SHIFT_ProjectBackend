package ftc.shift.sample.services;

import ftc.shift.sample.models.MoveNote;
import ftc.shift.sample.repositories.MoveNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MoveNoteService {
    private final MoveNoteRepository moveNoteRepository;

    @Autowired
    public MoveNoteService(MoveNoteRepository moveNoteRepository) {
        this.moveNoteRepository = moveNoteRepository;
    }

    public MoveNote provideMoveNote(String userId, String moveId, String moveNoteId) {
        return moveNoteRepository.fetchMoveNote(userId, moveId, moveNoteId);
    }

    public MoveNote updateMoveNote(String userId, String moveId, String moveNoteId, MoveNote moveNote) {
        return moveNoteRepository.updateMoveNote(userId, moveId, moveNoteId, moveNote);
    }

    public void deleteMoveNote(String userId, String moveId, String moveNoteId) {
        moveNoteRepository.deleteMoveNote(userId, moveId, moveNoteId);
    }

    public MoveNote createMoveNote(String userId, String moveId, MoveNote moveNote) {
        return moveNoteRepository.createMoveNote(userId, moveId, moveNote);
    }

    public Collection<MoveNote> provideMoveNotes(String userId, String moveId) {
        return moveNoteRepository.getAllMoveNotes(userId, moveId);
    }
}
