package org.sbryan.products_catalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.sbryan.products_catalog.codegen.types.Category;
import org.sbryan.products_catalog.db.CategoryRepository;
import org.sbryan.products_catalog.db.model.GlobalCategory;
import org.sbryan.products_catalog.mapper.CategoryMapper;
import org.sbryan.products_catalog.service.CategoryService;
import org.sbryan.products_catalog.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

/**
 *  Service to manage Category.
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ModelService modelService;

    @Override
    public GlobalCategory getCategory(String id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::map)
                .map(this::getModels)
                .orElse(null);
    }

    @Override
    public List<GlobalCategory> getCategories() {
        var categories = StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .map(categoryMapper::map)
                .toList();
        var models = modelService.getModelsByCategoryIds(collectCategoryIds(categories));

        categories.forEach(category ->
                category.setModels(models.get(category.getCategoryId()))
        );

        return categories;
    }

    @Override
    public Category create(Category category) {
        return categoryMapper.mapToCategory(categoryRepository.save(categoryMapper.map(category)));
    }

    private GlobalCategory getModels(GlobalCategory category) {
        return category.setModels(modelService.getModelsByCategoryId(category.getCategoryId()));
    }

    private List<String> collectCategoryIds(List<GlobalCategory> categories) {
        return categories.stream()
                .map(GlobalCategory::getCategoryId)
                .toList();
    }

}
