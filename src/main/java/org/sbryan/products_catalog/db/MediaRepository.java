package org.sbryan.products_catalog.db;

import org.sbryan.products_catalog.db.model.entity.MediaEntity;
import org.springframework.data.repository.CrudRepository;
import org.sbryan.products_catalog.codegen.types.Media;

import java.util.List;

public interface MediaRepository extends CrudRepository<MediaEntity, String> {

    List<MediaEntity> findMediaByModelCode(String modelCode);

    void deleteAllByModelCode(String modelCode);

}
