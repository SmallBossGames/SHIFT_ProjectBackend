package ftc.shift.sample.services;

import ftc.shift.sample.models.Travel;
import ftc.shift.sample.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TravelService {
    private final TravelRepository travelRepository;

    @Autowired
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public Travel provideTravel(String userId, String travelId) {
        return travelRepository.fetchTravel(userId, travelId);
    }

    public Travel updateTravel(String userId, String travelId, Travel travel) {
        return travelRepository.updateTravel(userId, travelId, travel);
    }

    public void deleteTravel(String userId, String travelId) {
        travelRepository.deleteTravel(userId, travelId);
    }

    public Travel createTravel(String userId, Travel travel) {
        return travelRepository.createTravel(userId, travel);
    }

    public Collection<Travel> provideTravel(String userId) {
        return travelRepository.getAllTravels(userId);
    }
}
