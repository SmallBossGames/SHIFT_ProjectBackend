package ftc.shift.sample.repositories;

import ftc.shift.sample.models.FinalPrice;

public interface FinalPriceRepository {
    FinalPrice fetchFinalPrice(String userId, String travelId);
}
