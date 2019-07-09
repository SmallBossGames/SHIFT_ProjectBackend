package ftc.shift.sample.api.notes;

import ftc.shift.sample.models.MoveNote;
import ftc.shift.sample.services.MoveNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MoveNotesController {
    private static final String MOVE_NOTE_PATH="/api/v001/notes/moves";
    private final MoveNoteService service;

    @Autowired
    public MoveNotesController(MoveNoteService service) {
        this.service = service;
    }

    @PostMapping(MOVE_NOTE_PATH)
    public ResponseEntity<MoveNote> addMoveNote(
            @RequestHeader("userId") String userId,
            @RequestParam("moveId") String moveId,
            @RequestBody MoveNote moveNote
    )
    {
        var result = service.createMoveNote(userId, moveId, moveNote);
        return ResponseEntity.ok(result);
    }

    @GetMapping(MOVE_NOTE_PATH + "/{moveNoteId}")
    public ResponseEntity<MoveNote> getMoveNote(
            @RequestHeader("userId") String userId,
            @RequestParam("moveId") String moveId,
            @PathVariable String moveNoteId
    )
    {
        var result = service.provideMoveNote(userId, moveId, moveNoteId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(MOVE_NOTE_PATH)
    public ResponseEntity<Collection<MoveNote>> getAllMoveNotes(
            @RequestHeader("userId") String userId,
            @RequestParam("moveId") String moveId
    )
    {
        var result = service.provideMoveNotes(userId, moveId);
        return ResponseEntity.ok(result);
    }

    @PatchMapping(MOVE_NOTE_PATH + "/{moveNoteId}")
    public ResponseEntity<MoveNote> updateMoveNote(
            @RequestHeader("userId") String userId,
            @RequestParam("moveId") String moveId,
            @PathVariable String moveNoteId,
            @RequestBody MoveNote moveNote
    )
    {
        var result = service.updateMoveNote(userId, moveId, moveNoteId, moveNote);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(MOVE_NOTE_PATH + "/{moveNoteId}")
    public ResponseEntity<?> deleteMoveNote(
            @RequestHeader("userId") String userId,
            @RequestParam("moveId") String moveId,
            @PathVariable String moveNoteId
    )
    {
        service.deleteMoveNote(userId, moveId, moveNoteId);
        return ResponseEntity.ok().build();
    }
}
