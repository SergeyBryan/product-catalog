package org.sbryan.products_catalog.db;

import org.sbryan.products_catalog.db.model.entity.PriceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {

    List<PriceEntity> findPriceEntityByProductId(String productId);

}
