package ftc.shift.sample.repositories;

import ftc.shift.sample.models.TravelNote;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class DatabaseTravelNoteRepository implements TravelNoteRepository {
    @Override
    public TravelNote fetchTravelNote(String userId, String travelId, String travelNoteId) {
        return new TravelNote("fwoiejifwe", "fwepkfewpk", "fpweoofewjefwjewf");
    }

    @Override
    public TravelNote updateTravelNote(String userId, String travelId, String travelNoteId, TravelNote travelNote) {
        return travelNote;
    }

    @Override
    public void deleteTravelNote(String userId, String travelId, String travelNoteId) {
        return;
    }

    @Override
    public TravelNote createTravelNote(String userId, String travelId, TravelNote travelNote) {
        return travelNote;
    }

    @Override
    public Collection<TravelNote> getAllTravelNotes(String userId, String travelId) {
        var temp = new ArrayList<TravelNote>();
        temp.add(new TravelNote("weffew", "fweweef","fewfewfew"));
        return temp;
    }
}
