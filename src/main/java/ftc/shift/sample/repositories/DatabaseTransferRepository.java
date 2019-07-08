package ftc.shift.sample.repositories;

import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.Transfer;
import ftc.shift.sample.repositories.extractors.TransferExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class DatabaseTransferRepository implements TransferRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final TransferExtractor extractor;

    @Autowired
    public DatabaseTransferRepository(NamedParameterJdbcTemplate jdbcTemplate, TransferExtractor extractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.extractor = extractor;
    }

    @Override
    public Transfer fetchTransfer(String userId, int transferId) {
        var sql = "SELECT ID, NAME FROM TRANSFERS WHERE ID = :transferId";
        var params = new MapSqlParameterSource()
                .addValue("transferId", transferId);
        var result = jdbcTemplate.query(sql, params, extractor);

        if(result.isEmpty())
        {
            throw new NotFoundException();
        }

        return result.get(0);
    }

    @Override
    public Transfer updateTransfer(String userId, int transferId, Transfer transfer) {
        return transfer;
    }

    @Override
    public void deleteTransfer(String userId, int transferId) {

    }

    @Override
    public Transfer createTransfer(String userId, Transfer transfer) {
        return transfer;
    }

    @Override
    public Collection<Transfer> getAllTransfers(String userId) {
        var sql = "SELECT ID, NAME FROM TRANSFERS";
        return jdbcTemplate.query(sql, extractor);
    }
}
