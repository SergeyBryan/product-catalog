package org.sbryan.products_catalog.service;

import java.util.List;

import org.sbryan.products_catalog.codegen.types.Price;

public interface PriceService {
    List<Price> getPricesByProductId(String productId);

    List<Price> updatePrices(List<Price> prices);

    Price updatePrice(Price price);

    Price create(Price price);
}
