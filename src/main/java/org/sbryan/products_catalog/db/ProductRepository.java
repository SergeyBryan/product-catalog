package org.sbryan.products_catalog.db;

import org.sbryan.products_catalog.db.model.entity.ProductEntity;
import org.sbryan.products_catalog.db.model.ProductPriceDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

import java.util.Collection;
import java.util.List;

@GraphQlRepository
public interface ProductRepository extends CrudRepository<ProductEntity, String> {
    @Query(value = "SELECT P.*, PR.DISCOUNT_PRICE as discountPrice, PR.base_price as price, margin "
            + "FROM PRODUCT P LEFT JOIN PRICE PR USING (product_id)",
            rowMapperClass = ProductPriceDto.class)
    List<ProductPriceDto> findAllLinkedPrice();

    List<ProductEntity> findAllByName(String name);

    List<ProductEntity> findAllByModelCode(String modelCode);

    List<ProductEntity> findAllByModelCodeIn(Collection<String> modelCodes);
}
