package org.sbryan.products_catalog.controller;

import lombok.RequiredArgsConstructor;
import org.sbryan.products_catalog.controller.converter.MediaConverter;
import org.sbryan.products_catalog.service.MediaService;
import org.sbryan.products_catalog.codegen.types.CreateMedia;
import org.sbryan.products_catalog.codegen.types.Media;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * A controller responsible for handling GraphQL queries and mutations related to media.
 * <p>
 * This class provides methods to create, fetch, and delete media using the {@link MediaService}.
 */
@Controller
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;
    private final MediaConverter converter;

    /**
     * Creates a new media entry using the provided input.
     *
     * @param createMedia the input object containing details for the new media.
     * @return the newly created {@link Media} object.
     */
    @MutationMapping
    public Media createMedia(@Argument CreateMedia createMedia) {
        return mediaService.saveMedia(converter.map(createMedia));
    }

    /**
     * Fetches all media entries associated with a specific model code.
     *
     * @param modelCode the unique code of the model.
     * @return a list of {@link Media} objects associated with the provided model code.
     */
    @QueryMapping
    public List<Media> getMediaByModelCode(@Argument String modelCode) {
        return mediaService.getMediaByModelCode(modelCode);
    }

    /**
     * Deletes all media entries associated with a specific model code.
     *
     * @param modelCode the unique code of the model.
     * @return a confirmation message indicating the deletion was successful.
     */
    @MutationMapping
    public String deleteMediaByModelCode(@Argument String modelCode) {
       return mediaService.deleteMediaByModelCode(modelCode);
    }

}
