package org.sbryan.products_catalog.db.model.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

public abstract class AbstractEntity {

    @CreatedDate
    @Column("created_date")
    protected LocalDateTime createdDate;
    @LastModifiedDate
    @Column("updated_date")
    protected LocalDateTime updatedDate;

}
