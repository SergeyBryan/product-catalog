package org.sbryan.products_catalog.db;

import org.sbryan.products_catalog.db.model.entity.ModelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.Collection;
import java.util.List;

@GraphQlRepository
public interface ModelRepository extends CrudRepository<ModelEntity, String> {

    ModelEntity findModelByModelCode(String modelCode);
    List<ModelEntity> findModelEntitiesByCategoryId(String categoryId);
    List<ModelEntity> findModelEntitiesByCategoryIdIn(Collection<String> categoryIds);
}
