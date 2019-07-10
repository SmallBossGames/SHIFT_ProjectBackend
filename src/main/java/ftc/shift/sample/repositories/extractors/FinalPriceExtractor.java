package ftc.shift.sample.repositories.extractors;

import ftc.shift.sample.models.FinalPrice;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class FinalPriceExtractor implements ResultSetExtractor<List<FinalPrice>> {

    @Override
    public List<FinalPrice> extractData(ResultSet rs) throws SQLException, DataAccessException {
        var finalPrices = new HashMap<String, FinalPrice>();
        while (rs.next())
        {
            String travelId = rs.getString("TRAVEL_ID");
            if(!finalPrices.containsKey(travelId))
            {
                var finalPrice = new FinalPrice();

                finalPrice.setId(rs.getString("TRAVEL_ID"));
                finalPrice.setPrice(rs.getBigDecimal("PRICE"));

                finalPrices.put(travelId, finalPrice);
            }
        }
        return new ArrayList<>(finalPrices.values());
    }
}
