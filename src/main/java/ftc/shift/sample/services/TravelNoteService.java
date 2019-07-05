package ftc.shift.sample.services;

import ftc.shift.sample.models.TravelNote;
import ftc.shift.sample.repositories.TravelNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TravelNoteService {
    private final TravelNoteRepository travelNoteRepository;

    @Autowired
    public TravelNoteService(TravelNoteRepository travelNoteRepository) {
        this.travelNoteRepository = travelNoteRepository;
    }

    public TravelNote provideTravelNote(String userId, String travelId, String travelNoteId) {
        return travelNoteRepository.fetchTravelNote(userId, travelId, travelNoteId);
    }

    public Collection<TravelNote> provideTravelNote(String userId, String travelId) {
        return travelNoteRepository.getAllTravelNotes(userId, travelId);
    }

    public TravelNote updateTravelNote(String userId, String travelId, String travelNoteId, TravelNote travelNote){
        return travelNoteRepository.updateTravelNote(userId, travelId, travelNoteId, travelNote);
    }

    public void deleteTravelNote(String userId, String travelId, String travelNoteId){
        travelNoteRepository.deleteTravelNote(userId, travelId, travelNoteId);
    }

    public TravelNote createTravelNote(String userId, String travelId, TravelNote travelNote){
        return travelNoteRepository.createTravelNote(userId, travelId, travelNote);
    }
}
