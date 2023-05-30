package pl.michal.SpendingTracker.controller;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.michal.SpendingTracker.dto.CategoryDto;
import pl.michal.SpendingTracker.model.Category;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDtoMapper {

    public static List<CategoryDto> mapToCategoryDtos(List<Category> categories) {
        return categories.stream()
                .map(category -> mapToCategoryDto(category))
                .collect(Collectors.toList());
    }

    private static CategoryDto mapToCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
