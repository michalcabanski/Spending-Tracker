package pl.michal.SpendingTracker.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.SpendingTracker.model.Operation;
import pl.michal.SpendingTracker.repository.OperationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;

    public List<Operation> getOperations(Integer year, Integer month) {
        if (year == null || month == null) {
            return operationRepository.findByOrderByCreated();
        }
        return operationRepository.findByYearAndMonthOrderByCreated(year, month);
    }

    public Operation getSingleOperation(long id) {
        return operationRepository.findById(id)
                .orElseThrow();
    }

    public Operation addOperation(Operation operation) {
        if (operation.getCreated() == null) {
            operation.setCreated(LocalDate.now());
        }
        return operationRepository.save(operation);
    }

    @Transactional
    public Operation updateOperation(long id, Operation updatedOperation) {
        Operation operation = operationRepository.findById(id)
                .orElseThrow();

        operation.setCategory_id(updatedOperation.getCategory_id());
        operation.setAmount(updatedOperation.getAmount());
        operation.setDescription(updatedOperation.getDescription());
        return operation;
    }

    public void deleteOperation(long id) {
        operationRepository.deleteById(id);
    }
}
