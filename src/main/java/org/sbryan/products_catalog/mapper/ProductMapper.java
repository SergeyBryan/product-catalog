package org.sbryan.products_catalog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sbryan.products_catalog.codegen.types.Product;
import org.sbryan.products_catalog.codegen.types.Price;
import org.sbryan.products_catalog.db.model.entity.ProductEntity;
import org.sbryan.products_catalog.db.model.ProductPriceDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product map(ProductEntity source);

    Product map(ProductPriceDto source);

    @Mapping(target = "name", expression = "java(source.getName().toUpperCase())")
    ProductEntity map(Product source);

    List<Product> map(List<ProductEntity> source);

    @Mapping(target = "basePrice", constant = "0D")
    @Mapping(target = "purchasePrice", constant = "0D")
    Price mapToPrice(Product product);

}
