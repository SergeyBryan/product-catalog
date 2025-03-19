package org.sbryan.products_catalog.service;

import java.util.List;

import org.sbryan.products_catalog.codegen.types.Media;

public interface MediaService {
    List<Media> getMediaByModelCode(String modelCode);

    Media saveMedia(Media media);

    String deleteMediaByModelCode(String modelCode);
}
