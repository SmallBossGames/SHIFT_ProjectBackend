package ftc.shift.sample.repositories.extractors;

import ftc.shift.sample.models.Transfer;
import ftc.shift.sample.models.TravelNote;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class TransferExtractor implements ResultSetExtractor<List<Transfer>> {

    @Override
    public List<Transfer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        var transfers = new HashMap<String, Transfer>();
        while (rs.next())
        {
            String id = rs.getString("ID");
            if(!transfers.containsKey(id))
            {
                var travelNote = new Transfer();

                travelNote.setId(rs.getInt("ID"));
                travelNote.setName(rs.getString("NAME"));

                transfers.put(id, travelNote);
            }
        }
        return new ArrayList<>(transfers.values());
    }
}
