package ftc.shift.sample.api.notes;

import ftc.shift.sample.models.TravelNote;
import ftc.shift.sample.services.TravelNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TravelNotesController {
    private static final String TRAVEL_NOTE_PATH="/api/v001/notes/travels";
    private final TravelNoteService travelNoteService;

    @Autowired
    public TravelNotesController(TravelNoteService travelService) {
        this.travelNoteService = travelService;
    }

    @PostMapping(TRAVEL_NOTE_PATH)
    public ResponseEntity<TravelNote> createTravelNote(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId,
            @RequestBody TravelNote travelNote
    )
    {
        var result = travelNoteService.createTravelNote(userId, travelId, travelNote);
        return ResponseEntity.ok(result);
    }

    @GetMapping(TRAVEL_NOTE_PATH + "/{travelNoteId}")
    public ResponseEntity<TravelNote> getTravelNote(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId,
            @PathVariable String travelNoteId
    )
    {
        var result=travelNoteService.provideTravelNote(userId, travelId, travelNoteId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(TRAVEL_NOTE_PATH)
    public ResponseEntity<Collection<TravelNote>> getAllTravelNotes(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId
    )
    {
        var result=travelNoteService.provideTravelNote(userId, travelId);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(TRAVEL_NOTE_PATH + "/{travelNoteId}")
    public ResponseEntity<?> deleteTravelNotes(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId,
            @PathVariable String travelNoteId
    )
    {
        travelNoteService.deleteTravelNote(userId, travelId, travelNoteId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(TRAVEL_NOTE_PATH + "/{travelNoteId}")
    public ResponseEntity<TravelNote> updateTravelNote(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId,
            @PathVariable String travelNoteId,
            @RequestBody TravelNote travelNote
    )
    {
        var result = travelNoteService.updateTravelNote(userId, travelId, travelNoteId, travelNote);
        return ResponseEntity.ok(result);
    }
}
