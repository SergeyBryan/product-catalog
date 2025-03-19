package org.sbryan.products_catalog.controller;

import lombok.RequiredArgsConstructor;
import org.sbryan.products_catalog.codegen.types.Category;
import org.sbryan.products_catalog.codegen.types.CreateCategory;
import org.sbryan.products_catalog.controller.converter.CatalogConverter;
import org.sbryan.products_catalog.service.CategoryService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * A controller responsible for handling GraphQL queries and mutations related to categories.
 * <p>
 * This class provides methods to fetch and create categories using the {@link CategoryService}.
 */
@Controller
@RequiredArgsConstructor
public class CatalogController {

    private final CategoryService categoryService;

    private final CatalogConverter converter;

    /**
     * Fetches a category by its unique identifier.
     *
     * @param id the unique identifier of the category.
     * @return the {@link Category} object corresponding to the provided ID.
     */
    @QueryMapping
    private Category findCategoryById(@Argument String id) {
        return converter.map(categoryService.getCategory(id));
    }

    /**
     * Fetches all available categories.
     *
     * @return a list of all {@link Category} objects.
     */
    @QueryMapping
    private List<Category> findCategories() {
        return converter.map(categoryService.getCategories());
    }

    /**
     * Creates a new category using the provided input.
     *
     * @param category the input object containing details for the new category.
     * @return the newly created {@link Category} object.
     */
    @MutationMapping
    private Category createCategory(@Argument CreateCategory category) {
        return categoryService.create(converter.map(category));
    }

}
