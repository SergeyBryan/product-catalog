package org.sbryan.products_catalog.service;

import org.sbryan.products_catalog.codegen.types.Model;

import java.util.List;
import java.util.Map;

public interface ModelService {

    Model getModel(String id);

    List<Model> getModels();

    List<Model> getModelsByCategoryId(String id);

    Map<String, List<Model>> getModelsByCategoryIds(List<String> ids);

    Model create(Model model);
}
