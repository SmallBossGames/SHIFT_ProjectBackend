package ftc.shift.sample.repositories;

import ftc.shift.sample.models.TravelNote;

import java.util.Collection;

public interface TravelNoteRepository {
    TravelNote fetchTravelNote(String userId, String travelId, String travelNoteId);

    TravelNote updateTravelNote(String userId, String travelId, String travelNoteId, TravelNote travelNote);

    void deleteTravelNote(String userId, String travelId, String travelNoteId);

    TravelNote createTravelNote(String userId, String travelId, TravelNote travelNote);

    Collection<TravelNote> getAllTravelNotes(String userId, String travelId);
}
