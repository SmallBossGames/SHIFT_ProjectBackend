package ftc.shift.sample.services;

import ftc.shift.sample.models.Transfer;
import ftc.shift.sample.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TransferService {
    private final TransferRepository transferRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public Transfer provideTransfer(String userId, int transferId)
    {
        return transferRepository.fetchTransfer(userId, transferId);
    }

    public Collection<Transfer> provideTransfers(String userId)
    {
        return transferRepository.getAllTransfers(userId);
    }

    public Transfer createTransfer(String userId, Transfer transfer)
    {
        return transferRepository.createTransfer(userId, transfer);
    }

    public Transfer updateTransfer(String userId, int transferId, Transfer transfer)
    {
        return transferRepository.updateTransfer(userId, transferId, transfer);
    }

    public void deleteTransfer(String userId, int transferId)
    {
        transferRepository.deleteTransfer(userId, transferId);
    }
}
