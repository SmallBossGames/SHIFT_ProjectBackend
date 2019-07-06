package ftc.shift.sample.repositories;

import ftc.shift.sample.models.MoveNote;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class DatabaseMoveNoteRepository implements MoveNoteRepository {
    @Override
    public MoveNote fetchMoveNote(String userId, String moveId, String moveNoteId) {
        return new MoveNote("wfwf", "fewqf", "wgegewepwrgkperkgrpwekprg");
    }

    @Override
    public MoveNote updateMoveNote(String userId, String moveId, String moveNoteId, MoveNote moveNote) {
        return moveNote;
    }

    @Override
    public void deleteMoveNote(String userId, String moveId, String moveNoteId) {

    }

    @Override
    public MoveNote createMoveNote(String userId, String moveId, MoveNote moveNote) {
        return moveNote;
    }

    @Override
    public Collection<MoveNote> getAllMoveNotes(String userId, String moveId) {
        var list = new ArrayList<MoveNote>();
        list.add(new MoveNote("wfwf", "fewqf", "wgegewepwrgkperkgrpwekprg"));
        return list;
    }
}
