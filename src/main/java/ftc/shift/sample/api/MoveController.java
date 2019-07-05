package ftc.shift.sample.api;

import ftc.shift.sample.models.Move;
import ftc.shift.sample.services.MoveService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
            @RequestBody Move move) {
        var result = service.createMove(userId, travelId, move);
        return ResponseEntity.ok(result);
    }


}
