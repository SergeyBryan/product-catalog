package org.sbryan.products_catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication
@EnableJdbcAuditing
public class ProductsCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsCatalogApplication.class, args);
    }

}
