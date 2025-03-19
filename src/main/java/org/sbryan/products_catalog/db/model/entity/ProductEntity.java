package org.sbryan.products_catalog.db.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "product")
@Builder
@Getter
public class ProductEntity extends AbstractEntity {

    @Id
    @Column(value = "product_id")
    private String productId;
    @Column(value = "name")
    private String name;
    @Column(value = "description")
    private String description;
    @Column(value = "model_code")
    private String modelCode;


}
