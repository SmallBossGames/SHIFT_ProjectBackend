package ftc.shift.sample.repositories.extractors;

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
public class TravelNoteExtractor implements ResultSetExtractor<List<TravelNote>> {
    @Override
    public List<TravelNote> extractData(ResultSet rs) throws SQLException, DataAccessException {
        var travelNotes = new HashMap<String, TravelNote>();
        while (rs.next())
        {
            var id = rs.getString("ID");

            if(!travelNotes.containsKey(id))
            {
                var travelNote = new TravelNote();

                travelNote.setId(rs.getString("ID"));
                travelNote.setText(rs.getString("TEXT"));
                travelNote.setTitle(rs.getString("TITLE"));

                travelNotes.put(id, travelNote);
            }
        }
        return new ArrayList<>(travelNotes.values());
    }
}
