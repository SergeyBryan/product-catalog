package org.sbryan.products_catalog.controller.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sbryan.products_catalog.codegen.types.Price;
import org.sbryan.products_catalog.codegen.types.UpdatePrice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceConverter {

    @Mapping(target = "marginValue", expression = "java(calculateMarginValue(source))")
    @Mapping(target = "margin", expression = "java(calculateMargin(source))")
    Price map(UpdatePrice source);

    List<Price> map(List<UpdatePrice> source);

    default Double calculateMarginValue(UpdatePrice price) {
        if (price == null) {
            return null;
        }
        var contractPrice = BigDecimal.valueOf(price.getContactPrice());
        var finalPrice = calculateFinalPrice(price);
        return finalPrice.subtract(contractPrice).doubleValue();
    }

    default String calculateMargin(UpdatePrice price) {
        if (price == null) {
            return null;
        }
        var contractPrice = BigDecimal.valueOf(price.getContactPrice());
        var finalPrice = calculateFinalPrice(price);
        return finalPrice.subtract(contractPrice).divide(finalPrice, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100)).toString();
    }

    default BigDecimal calculateFinalPrice(UpdatePrice price) {
        return price.getDiscountPrice() == null ?
                BigDecimal.valueOf(price.getBasePrice()) : BigDecimal.valueOf(price.getDiscountPrice());
    }


}
