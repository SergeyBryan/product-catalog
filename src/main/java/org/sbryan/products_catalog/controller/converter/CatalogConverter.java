package org.sbryan.products_catalog.controller.converter;

import org.mapstruct.Mapper;
import org.sbryan.products_catalog.codegen.types.Category;
import org.sbryan.products_catalog.codegen.types.CreateCategory;
import org.sbryan.products_catalog.db.model.GlobalCategory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatalogConverter {

    Category map(GlobalCategory source);

    List<Category> map(List<GlobalCategory> source);

    Category map(CreateCategory source);

}