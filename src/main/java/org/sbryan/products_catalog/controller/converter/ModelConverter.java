package org.sbryan.products_catalog.controller.converter;

import org.mapstruct.Mapper;
import org.sbryan.products_catalog.codegen.types.Model;
import org.sbryan.products_catalog.codegen.types.CreateModel;

@Mapper(componentModel = "spring")
public interface ModelConverter {

    Model map(CreateModel model);

}
