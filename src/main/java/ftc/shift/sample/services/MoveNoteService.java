package ftc.shift.sample.services;

import ftc.shift.sample.models.MoveNote;
import ftc.shift.sample.repositories.MoveNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

//@Service
public class MoveNoteService {
    private final MoveNoteRepository moveNoteRepository;

    @Autowired
    public MoveNoteService(MoveNoteRepository moveNoteRepository) {
        this.moveNoteRepository = moveNoteRepository;
    }

    public MoveNote provideMoveNote(String userId, String moveNoteId) {
        return moveNoteRepository.fetchMoveNote(userId, moveNoteId);
    }

    public MoveNote updateMoveNote(String moveId, String moveNoteId, MoveNote moveNote) {
        return moveNoteRepository.updateMoveNote(moveId, moveNoteId, moveNote);
    }

    public void deleteMoveNote(String moveId, String moveNoteId) {
        moveNoteRepository.deleteMoveNote(moveId, moveNoteId);
    }

    public MoveNote createMoveNote(String moveId, MoveNote moveNote) {
        return moveNoteRepository.createMoveNote(moveId, moveNote);
    }

    public Collection<MoveNote> provideMoveNotes(String moveId) {
        return moveNoteRepository.getAllMoveNotes(moveId);
    }
}
