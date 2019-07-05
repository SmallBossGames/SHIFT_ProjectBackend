package ftc.shift.sample.api;

import ftc.shift.sample.models.Travel;
import ftc.shift.sample.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TravelsController {
    private static final String TRAVEL_PATH = "/api/v001/travels";

    private final TravelService service;

    @Autowired
    public TravelsController(TravelService service)
    {
        this.service = service;
    }

    @PostMapping(TRAVEL_PATH)
    public ResponseEntity<Travel> createTravel(
            @RequestHeader("userId") String userId,
            @RequestBody Travel travel)
    {
        var result = service.createTravel(userId, travel);
        return ResponseEntity.ok(result);
    }

    @GetMapping(TRAVEL_PATH + "/{travelId}")
    public  ResponseEntity<Travel> getTravel(
            @RequestHeader("userId") String userId,
            @PathVariable String travelId){
        var travel = service.provideTravel(userId, travelId);
        return ResponseEntity.ok(travel);
    }

    @GetMapping(TRAVEL_PATH)
    public  ResponseEntity<Collection<Travel>> getAllTravels(
            @RequestHeader("userId") String userId
    )
    {
        var result = service.provideTravel(userId);
        return ResponseEntity.ok(result);
    }

    @PatchMapping(TRAVEL_PATH + "/{travelId}")
    public ResponseEntity<Travel> updateTravel(
            @RequestHeader("userId") String userId,
            @PathVariable String travelId,
            @RequestBody Travel travel
    )
    {
        var result = service.updateTravel(userId, travelId, travel);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(TRAVEL_PATH + "/{travelId}")
    public ResponseEntity<?> deleteTravel(
            @RequestHeader("userId") String userId,
            @PathVariable String travelId
    )
    {
        service.deleteTravel(userId, travelId);
        return ResponseEntity.ok().build();
    }
}