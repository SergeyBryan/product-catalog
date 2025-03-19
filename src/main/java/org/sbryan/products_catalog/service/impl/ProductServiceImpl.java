package org.sbryan.products_catalog.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sbryan.products_catalog.codegen.types.Product;
import org.sbryan.products_catalog.db.ProductRepository;
import org.sbryan.products_catalog.mapper.ProductMapper;
import org.sbryan.products_catalog.service.PriceService;
import org.sbryan.products_catalog.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final PriceService priceService;

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id)
                .map(mapper::map)
                .orElse(null);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAllLinkedPrice().stream()
                .map(mapper::map)
                .toList();
    }

    @Override
    public List<Product> getProductsByModelCode(String modelCode) {
        return mapper.map(productRepository.findAllByModelCode(modelCode));
    }

    @Override
    public List<Product> getProductsByModelCodes(List<String> modelCodes) {
        return mapper.map(productRepository.findAllByModelCodeIn(modelCodes));
    }

    @Override
    public Product create(Product product) {
        var prod = mapper.map(productRepository.save(mapper.map(product)));
        priceService.create(mapper.mapToPrice(prod));
        return prod;
    }

}
