package pl.michal.SpendingTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.michal.SpendingTracker.model.Operation;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByUserIdOrderByCreatedDesc(Long userId);

    Optional<Operation> findByUserIdAndId(Long userId, Long Id);

    @Query(value = "select * from Operation o where o.user_id = ?1 and year(o.created) = ?2 and month(o.created) = ?3 order by o.created desc",
            nativeQuery = true)
    List<Operation> findByUserIdAndYearAndMonthOrderByCreated(Long userId, Integer year, Integer month);
}
