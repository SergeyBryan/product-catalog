package org.sbryan.products_catalog.db.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.sbryan.products_catalog.codegen.types.Model;

import java.util.List;

@Data
@Accessors(chain = true)
public class GlobalCategory {

    private String categoryId;
    private String categoryName;
    private Boolean active;
    private List<Model> models;

}
