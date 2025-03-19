package org.sbryan.products_catalog.service;

import org.sbryan.products_catalog.codegen.types.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(String id);

    List<Product> getProducts();

    List<Product> getProductsByModelCode(String modelCode);

    List<Product> getProductsByModelCodes(List<String> modelCodes);

    Product create(Product product);
}
