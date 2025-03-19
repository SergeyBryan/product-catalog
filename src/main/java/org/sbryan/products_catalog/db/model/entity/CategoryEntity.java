package org.sbryan.products_catalog.db.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("category")
@Getter
@Builder
public class CategoryEntity extends AbstractEntity {

    @Id
    @Column("category_id")
    private String categoryId;
    @Column("category_name")
    private String categoryName;
    @Column("active")
    private Boolean active;

}
