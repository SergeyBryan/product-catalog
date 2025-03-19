package org.sbryan.products_catalog.controller.converter;


import org.mapstruct.Mapper;
import org.sbryan.products_catalog.codegen.types.Product;
import org.sbryan.products_catalog.codegen.types.CreateProduct;

@Mapper(componentModel = "spring")
public interface ProductConverter {

    Product map(CreateProduct source);

}
