package pl.michal.SpendingTracker.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.michal.SpendingTracker.model.Category;
import pl.michal.SpendingTracker.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getSingleCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(Long id, Category updatedCategory) {
        Category category = categoryRepository.findById(id)
                .orElseThrow();

        category.setName(updatedCategory.getName());
        return category;
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
