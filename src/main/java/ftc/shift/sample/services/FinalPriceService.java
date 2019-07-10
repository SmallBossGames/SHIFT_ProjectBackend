package ftc.shift.sample.services;

import ftc.shift.sample.models.FinalPrice;
import ftc.shift.sample.repositories.FinalPriceRepository;
import org.springframework.stereotype.Service;

@Service
public class FinalPriceService {

    private final FinalPriceRepository repository;

    public FinalPriceService(FinalPriceRepository repository) {
        this.repository = repository;
    }

    public FinalPrice getFinalPrice(String userid, String travelId){
        return repository.fetchFinalPrice(userid, travelId);
    }
}
