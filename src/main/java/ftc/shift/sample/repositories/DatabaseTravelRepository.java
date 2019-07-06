package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Travel;
import ftc.shift.sample.models.Move;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class DatabaseTravelRepository implements TravelRepository {
    @Override
    public Travel fetchTravel(String userId, String travelId) {
        return new Travel("hui", "zalupa");
    }

    @Override
    public Travel updateTravel(String userId, String travelId, Travel travel) {
        return travel;
    }

    @Override
    public void deleteTravel(String userId, String travelId) {
        return;
    }

    @Override
    public Travel createTravel(String userId, Travel travel) {
        return travel;
    }

    @Override
    public Collection<Travel> getAllTravels(String userId) {
        var temp = new ArrayList<Travel>();
        temp.add(new Travel("hui", "zalupa"));
        temp.add(new Travel("hui2", "java sucks"));
        return temp;
    }
}
