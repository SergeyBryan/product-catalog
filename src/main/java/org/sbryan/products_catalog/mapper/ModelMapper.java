package org.sbryan.products_catalog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sbryan.products_catalog.codegen.types.Model;
import org.sbryan.products_catalog.db.model.entity.ModelEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ModelMapper {

    Model map(ModelEntity source);

    @Mapping(target = "modelName", expression = "java(source.getModelName().toUpperCase())")
    ModelEntity map(Model source);

    List<Model> map(List<ModelEntity> source);

    default Map<String, List<Model>> mapToMap(List<ModelEntity> source) {
        return source.stream()
                .collect(Collectors.groupingBy(
                        ModelEntity::getCategoryId,
                        Collectors.mapping(this::map, Collectors.toList())
                ));
    }

}
