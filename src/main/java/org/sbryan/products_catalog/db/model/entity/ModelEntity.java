package org.sbryan.products_catalog.db.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("model")
@Getter
@Builder
public class ModelEntity extends AbstractEntity {

    @Id
    @Column(value = "model_code")
    private String modelCode;
    @Column(value = "model_name")
    private String modelName;
    @Column(value = "model_description")
    private String modelDescription;
    @Column(value = "category_id")
    private String categoryId;

}
