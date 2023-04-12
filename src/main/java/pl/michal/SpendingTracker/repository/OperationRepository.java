package pl.michal.SpendingTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.michal.SpendingTracker.model.Operation;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByOrderByCreated();

    @Query(value = "select * from Operation o where year(o.created) = ?1 and month(o.created) = ?2 order by o.created",
            nativeQuery = true)
    List<Operation> findByYearAndMonthOrderByCreated(Integer year, Integer month);
}
