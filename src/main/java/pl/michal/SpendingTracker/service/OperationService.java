package pl.michal.SpendingTracker.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.SpendingTracker.model.Operation;
import pl.michal.SpendingTracker.model.User;
import pl.michal.SpendingTracker.repository.OperationRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;

    public List<Operation> getOperations(
            User user,
            Integer year,
            Integer month
    ) {
        if (year == null || month == null) {
            return operationRepository.findByUserIdOrderByCreated(user.getId());
        } else {
            return operationRepository.findByUserIdAndYearAndMonthOrderByCreated(user.getId(), year, month);
        }
    }

    public BigDecimal getBalance(
            User user,
            Integer year,
            Integer month
    ) {
        if (year == null || month == null) {
            return operationRepository.findByUserIdOrderByCreated(user.getId())
                    .stream()
                    .map(Operation::getAmount)
                    .reduce(BigDecimal::add)
                    .get();
        } else {
            return operationRepository
                    .findByUserIdAndYearAndMonthOrderByCreated(user.getId(), year, month)
                    .stream()
                    .map(Operation::getAmount)
                    .reduce(BigDecimal::add)
                    .get();
        }
    }

    public Operation getSingleOperation(User user, long id) {
        return operationRepository.findByUserIdAndId(user.getId(), id)
                .orElseThrow();
    }

    public Operation addOperation(User user, Operation operation) {
        if (operation.getCreated() == null) {
            operation.setCreated(LocalDate.now());
        }
        operation.setUserId(user.getId());
        return operationRepository.save(operation);
    }

    @Transactional
    public Operation updateOperation(User user, long id, Operation updatedOperation) throws Exception {
        Operation operation = operationRepository.findById(id)
                .orElseThrow();

        if(user.getId() != operation.getUserId()) {
            throw new Exception();
        }

        operation.setCategoryId(updatedOperation.getCategoryId());
        operation.setAmount(updatedOperation.getAmount());
        operation.setDescription(updatedOperation.getDescription());
        return operation;
    }

    public void deleteOperation(User user, long id) throws Exception {
        if(user.getId() != operationRepository.findById(id).orElseThrow().getUserId()) {
            throw new Exception();
        }

        operationRepository.deleteById(id);
    }
}
