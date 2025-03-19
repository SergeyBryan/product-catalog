package org.sbryan.products_catalog.db.model;

import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class ProductPriceDto implements RowMapper {

    private String productId;
    private String name;
    private String description;
    private String modelCode;
    private BigDecimal discountPrice;
    private BigDecimal price;
    private String margin;

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductPriceDto productPriceDto = new ProductPriceDto();
        productPriceDto.setProductId(rs.getString("product_id"));
        productPriceDto.setName(rs.getString("name"));
        productPriceDto.setDescription(rs.getString("description"));
        productPriceDto.setModelCode(rs.getString("model_code"));
        productPriceDto.setDiscountPrice(rs.getBigDecimal("discountPrice"));
        productPriceDto.setPrice(rs.getBigDecimal("price"));
        productPriceDto.setMargin(rs.getString("margin"));
        return productPriceDto;
    }
}
