package pl.michal.SpendingTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michal.SpendingTracker.model.Operation;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByOrderByCreated();
}
