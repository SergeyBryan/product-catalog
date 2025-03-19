package org.sbryan.products_catalog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sbryan.products_catalog.codegen.types.Category;
import org.sbryan.products_catalog.db.model.entity.CategoryEntity;
import org.sbryan.products_catalog.db.model.GlobalCategory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    GlobalCategory map(CategoryEntity source);

    Category mapToCategory(CategoryEntity source);

    @Mapping(target = "categoryName", expression = "java(source.getCategoryName().toUpperCase())")
    CategoryEntity map(Category source);

    List<GlobalCategory> map(List<CategoryEntity> source);
}
