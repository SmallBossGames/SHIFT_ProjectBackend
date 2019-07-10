package ftc.shift.sample.api;

import ftc.shift.sample.models.FinalPrice;
import ftc.shift.sample.services.FinalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FinalPriceController {
    private static final String FINAL_PRICE_PATH = "/api/v001/finalPrice";
    private final FinalPriceService service;

    @Autowired
    public FinalPriceController(FinalPriceService service) {
        this.service = service;
    }

    @GetMapping(FINAL_PRICE_PATH + "/{travelId}")
    public ResponseEntity<FinalPrice> getFinalPrice(
            @RequestHeader("userId") String userId,
            @PathVariable String travelId
    )
    {
        var result = service.getFinalPrice(userId, travelId);
        return ResponseEntity.ok(result);
    }
}
