package org.sbryan.products_catalog.mapper;

import org.mapstruct.Mapper;
import org.sbryan.products_catalog.db.model.entity.PriceEntity;
import org.sbryan.products_catalog.codegen.types.Price;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price map(PriceEntity source);

    PriceEntity map(Price source);

    List<Price> map(List<PriceEntity> source);

}
