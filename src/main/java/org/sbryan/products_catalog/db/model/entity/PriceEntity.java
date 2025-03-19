package org.sbryan.products_catalog.db.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("price")
@Builder
@Getter
public class PriceEntity extends AbstractEntity{

    @Id
    private Integer id;
    @Column("product_id")
    private String productId;
    @Column("base_price")
    private Float basePrice;
    @Column("discount_price")
    private Float discountPrice;
    @Column("purchase_price")
    private Float purchasePrice;
    @Column("contract_price")
    private Float contractPrice;
    @Column("markup")
    private String markup;
    @Column("margin")
    private String margin;
    @Column("marginValue")
    private Float marginValue;

}
