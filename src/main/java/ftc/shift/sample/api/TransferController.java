package ftc.shift.sample.api;

import ftc.shift.sample.models.Transfer;
import ftc.shift.sample.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TransferController {
    private static final String TRANSFERS_PATH = "/api/v001/transfers";
    private final TransferService service;

    @Autowired
    public TransferController(TransferService service) {
        this.service = service;
    }

    @GetMapping(TRANSFERS_PATH + "/{transferId}")
    public ResponseEntity<Transfer> getTransfer(
            @RequestHeader("userId") String userId,
            @PathVariable int transferId
    )
    {
        var result = service.provideTransfer(userId, transferId);
        return ResponseEntity.ok(result);
    }

    @GetMapping(TRANSFERS_PATH)
    public ResponseEntity<Collection<Transfer>> getAllTransfers(
            @RequestHeader("userId") String userId
    )
    {
        var result = service.provideTransfers(userId);
        return ResponseEntity.ok(result);
    }
}
