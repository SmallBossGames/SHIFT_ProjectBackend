package ftc.shift.sample.repositories;

import ftc.shift.sample.models.MoveNote;

import java.util.Collection;

public interface MoveNoteRepository {
    MoveNote fetchMoveNote(String moveId, String moveNoteId);

    MoveNote updateMoveNote(String moveId, String moveNoteId, MoveNote moveNote);

    void deleteMoveNote(String moveId, String moveNoteId);

    MoveNote createMoveNote(String moveId, MoveNote moveNote);

    Collection<MoveNote> getAllMoveNotes(String userId);
}
