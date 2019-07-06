package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Transfer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class DatabaseTransferRepository implements TransferRepository {
    @Override
    public Transfer fetchTransfer(String userId, int transferId) {
        return new Transfer(10, "name");
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
        var temp = new ArrayList<Transfer>();
        temp.add(new Transfer(10, "name"));
        return temp;
    }
}
