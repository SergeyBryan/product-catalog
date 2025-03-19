package org.sbryan.products_catalog.controller.converter;

import org.mapstruct.Mapper;
import org.sbryan.products_catalog.codegen.types.Media;
import org.sbryan.products_catalog.codegen.types.CreateMedia;

@Mapper(componentModel = "spring")
public interface MediaConverter {

    Media map(CreateMedia media);

}
