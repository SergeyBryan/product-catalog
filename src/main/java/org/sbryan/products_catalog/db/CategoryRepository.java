package org.sbryan.products_catalog.db;

import org.sbryan.products_catalog.db.model.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<CategoryEntity, String> {
}
