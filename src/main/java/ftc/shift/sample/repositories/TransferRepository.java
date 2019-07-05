package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Transfer;

import java.util.Collection;

public interface TransferRepository {
    Transfer fetchTransfer(String userId, int transferId);

    Transfer updateTransfer(String userId, int transferId, Transfer transfer);

    void deleteTransfer(String userId, int transferId);

    Transfer createTransfer(String userId, Transfer transfer);

    Collection<Transfer> getAllTransfers(String userId);
}
