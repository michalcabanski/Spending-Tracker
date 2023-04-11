package pl.michal.SpendingTracker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.michal.SpendingTracker.controller.dto.CategoryDto;
import pl.michal.SpendingTracker.model.Category;
import pl.michal.SpendingTracker.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public List<CategoryDto> getCategories() {
        return CategoryDtoMapper.mapToCategoryDtos(categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public Category getSingleCategory(@PathVariable Long id) {
        return categoryService.getSingleCategory(id);
    }

    @PostMapping("")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        return categoryService.updateCategory(id, updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
