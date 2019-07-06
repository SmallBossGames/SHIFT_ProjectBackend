package ftc.shift.sample.api;

import ftc.shift.sample.models.Move;
import ftc.shift.sample.services.MoveService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MoveController {
    private static final String MOVES_PATH = "/api/v001/moves";

    private final MoveService service;

    @Autowired
    public MoveController(MoveService repository){
        this.service = repository;
    }

    @PostMapping(MOVES_PATH)
    public ResponseEntity<Move> createMove(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId,
            @RequestBody Move move
    )
    {
        var result = service.createMove(userId, travelId, move);
        return ResponseEntity.ok(result);
    }

    @GetMapping(MOVES_PATH + "/{moveId}")
    public ResponseEntity<Move> getMove(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId,
            @PathVariable String moveId
    )
    {
        var result = service.provideMove(userId, travelId, moveId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(MOVES_PATH)
    public ResponseEntity<Collection<Move>> getAllMoves(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId
    )
    {
        var result = service.provideMoves(userId, travelId);
        return  ResponseEntity.ok(result);
    }

    @PatchMapping(MOVES_PATH + "/{moveId}")
    public ResponseEntity<Move> updateMove(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId,
            @PathVariable String moveId,
            @RequestBody Move move
    )
    {
        var result = service.updateMove(userId, travelId, moveId, move);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(MOVES_PATH + "/{moveId}")
    public ResponseEntity<?> deleteMove(
            @RequestHeader("userId") String userId,
            @RequestParam("travelId") String travelId,
            @PathVariable String moveId
    )
    {
        service.deleteMove(userId, travelId, moveId);
        return ResponseEntity.ok().build();
    }
}
