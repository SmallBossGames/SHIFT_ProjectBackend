package ftc.shift.sample.repositories.extractors;

import ftc.shift.sample.models.MoveNote;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MoveNoteExtractor implements ResultSetExtractor<List<MoveNote>> {
    @Override
    public List<MoveNote> extractData(ResultSet rs) throws SQLException, DataAccessException
    {
        var moveNotes = new HashMap<String, MoveNote>();
        while (rs.next())
        {
            var id = rs.getString("ID");

            if(!moveNotes.containsKey(id))
            {
                var moveNote = new MoveNote();

                moveNote.setId(rs.getString("ID"));
                moveNote.setText(rs.getString("TEXT"));
                moveNote.setTitle(rs.getString("TITLE"));

                moveNotes.put(id, moveNote);
            }
        }
        return new ArrayList<>(moveNotes.values());
    }
}
