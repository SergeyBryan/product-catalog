package org.sbryan.products_catalog.service.impl;

import lombok.RequiredArgsConstructor;
import org.sbryan.products_catalog.codegen.types.Model;
import org.sbryan.products_catalog.db.ModelRepository;
import org.sbryan.products_catalog.mapper.ModelMapper;
import org.sbryan.products_catalog.service.MediaService;
import org.sbryan.products_catalog.service.ModelService;
import org.sbryan.products_catalog.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ProductService productService;
    private final MediaService mediaService;
    private final ModelMapper mapper;

    @Override
    public Model getModel(String id) {
        var model = mapper.map(modelRepository.findModelByModelCode(id));
        model.setProducts(productService.getProductsByModelCode(model.getModelCode()));
        model.setMedia(mediaService.getMediaByModelCode(model.getModelCode()));
        return model;
    }

    @Override
    public List<Model> getModels() {
        return StreamSupport.stream(modelRepository.findAll().spliterator(), false)
                .map(mapper::map)
                .peek(p -> p.setProducts(productService.getProductsByModelCode(p.getModelCode())))
                .toList();
    }

    @Override
    public List<Model> getModelsByCategoryId(String id) {
        return mapper.map(modelRepository.findModelEntitiesByCategoryId(id));
    }

    @Override
    public Map<String, List<Model>> getModelsByCategoryIds(List<String> ids) {
        return mapper.mapToMap(modelRepository.findModelEntitiesByCategoryIdIn(ids));
    }

    @Override
    public Model create(Model model) {
        return mapper.map(modelRepository.save(mapper.map(model)));
    }
}
