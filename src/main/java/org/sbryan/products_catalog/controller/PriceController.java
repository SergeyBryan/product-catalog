package org.sbryan.products_catalog.controller;

import lombok.RequiredArgsConstructor;
import org.sbryan.products_catalog.controller.converter.PriceConverter;
import org.sbryan.products_catalog.service.PriceService;
import org.sbryan.products_catalog.codegen.types.Price;
import org.sbryan.products_catalog.codegen.types.UpdatePrice;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * A controller responsible for handling GraphQL queries and mutations related to prices.
 * <p>
 * This class provides methods to fetch and update prices using the {@link PriceService}.
 */
@Controller
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;
    private final PriceConverter converter;

    /**
     * Fetches all prices associated with a specific product ID.
     *
     * @param productId the unique identifier of the product.
     * @return a list of {@link Price} objects associated with the provided product ID.
     */
    @QueryMapping
    private List<Price> getPrices(@Argument String productId) {
        return priceService.getPricesByProductId(productId);
    }

    /**
     * Updates a single price entry using the provided input.
     *
     * @param price the input object containing updated price details.
     * @return the updated {@link Price} object.
     */
    @MutationMapping
    private Price updatePrice(@Argument UpdatePrice price) {
        return priceService.updatePrice(converter.map(price));
    }

    /**
     * Updates multiple price entries using the provided list of inputs.
     *
     * @param priceList a list of input objects containing updated price details.
     * @return a list of updated {@link Price} objects.
     */
    @MutationMapping
    private List<Price> updatePrices(@Argument List<UpdatePrice> priceList) {
        return priceService.updatePrices(converter.map(priceList));
    }

}
