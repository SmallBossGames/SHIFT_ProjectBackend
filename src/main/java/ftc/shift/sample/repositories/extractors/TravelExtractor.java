package ftc.shift.sample.repositories.extractors;

import ftc.shift.sample.models.Travel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class TravelExtractor implements ResultSetExtractor<List<Travel>> {
    @Override
    public List<Travel> extractData(ResultSet rs) throws SQLException, DataAccessException {
        var travels = new HashMap<String, Travel>();

        while (rs.next()){
            String id = rs.getString("ID");

            if(!travels.containsKey(id))
            {
                var travel = new Travel();

                travel.setId(rs.getString("ID"));
                travel.setName(rs.getString("NAME"));

                travels.put(id, travel);
            }
        }
        return new ArrayList<>(travels.values());
    }
}
