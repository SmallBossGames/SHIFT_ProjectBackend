package ftc.shift.sample.repositories;
import ftc.shift.sample.models.Travel;

import java.util.Collection;

public interface TravelRepository {
    Travel fetchTravel(String userId, String travelId);

    Travel updateTravel(String userId, String travelId, Travel travel);

    void deleteTravel(String userId, String travelId);

    Travel createTravel(String userId, Travel travel);

    Collection<Travel> getAllTravels(String userId);
}
