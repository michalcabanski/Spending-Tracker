package pl.michal.SpendingTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michal.SpendingTracker.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
