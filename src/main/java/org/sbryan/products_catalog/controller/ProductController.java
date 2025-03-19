package org.sbryan.products_catalog.controller;

import lombok.RequiredArgsConstructor;
import org.sbryan.products_catalog.codegen.types.Product;
import org.sbryan.products_catalog.codegen.types.CreateProduct;
import org.sbryan.products_catalog.controller.converter.ProductConverter;
import org.sbryan.products_catalog.service.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * A controller responsible for handling GraphQL queries and mutations related to products.
 * <p>
 * This class provides methods to fetch and create products using the {@link ProductService}.
 */
@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductConverter converter;

    /**
     * Fetches a product by its unique identifier.
     *
     * @param id the unique identifier of the product.
     * @return the {@link Product} object corresponding to the provided ID.
     */
    @QueryMapping
    private Product findByProductId(@Argument String id) {
        return productService.getProduct(id);
    }

    /**
     * Fetches all available products.
     *
     * @return a list of all {@link Product} objects.
     */
    @QueryMapping
    private List<Product> findAllProducts() {
        return productService.getProducts();
    }

    /**
     * Creates a new product using the provided input.
     *
     * @param product the input object containing details for the new product.
     * @return the newly created {@link Product} object.
     */
    @MutationMapping
    private Product createProduct(@Argument CreateProduct product) {
        return productService.create(converter.map(product));
    }

}
