package org.sbryan.products_catalog;

import org.springframework.boot.SpringApplication;

public class TestProductsCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.from(ProductsCatalogApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
