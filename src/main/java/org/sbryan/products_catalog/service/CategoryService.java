package org.sbryan.products_catalog.service;

import org.sbryan.products_catalog.codegen.types.Category;
import org.sbryan.products_catalog.db.model.GlobalCategory;

import java.util.List;

public interface CategoryService {

    GlobalCategory getCategory(String id);

    List<GlobalCategory> getCategories();

    Category create(Category category);
}
