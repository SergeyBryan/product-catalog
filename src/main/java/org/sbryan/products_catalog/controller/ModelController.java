package org.sbryan.products_catalog.controller;

import lombok.RequiredArgsConstructor;
import org.sbryan.products_catalog.codegen.types.Model;
import org.sbryan.products_catalog.codegen.types.CreateModel;
import org.sbryan.products_catalog.controller.converter.ModelConverter;
import org.sbryan.products_catalog.service.ModelService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * A controller responsible for handling GraphQL queries and mutations related to models.
 * <p>
 * This class provides methods to fetch and create models using the {@link ModelService}.
 */
@Controller
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;
    private final ModelConverter converter;

    /**
     * Fetches a model by its unique identifier.
     *
     * @param id the unique identifier of the model.
     * @return the {@link Model} object corresponding to the provided ID.
     */
    @QueryMapping
    private Model findByModelCode(@Argument String id) {
        return modelService.getModel(id);
    }

    /**
     * Fetches all available models.
     *
     * @return a list of all {@link Model} objects.
     */
    @QueryMapping
    private List<Model> findAllModels() {
        return modelService.getModels();
    }

    /**
     * Creates a new model using the provided input.
     *
     * @param model the input object containing details for the new model.
     * @return the newly created {@link Model} object.
     */
    @MutationMapping
    private Model createModel(@Argument CreateModel model) {
        return modelService.create(converter.map(model));
    }

}
