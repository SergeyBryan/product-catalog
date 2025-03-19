package org.sbryan.products_catalog.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sbryan.products_catalog.codegen.types.Media;
import org.sbryan.products_catalog.db.MediaRepository;
import org.sbryan.products_catalog.mapper.MediaMapper;
import org.sbryan.products_catalog.service.MediaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;
    private final MediaMapper mapper;

    @Override
    public List<Media> getMediaByModelCode(String modelCode) {
        var medias = (mediaRepository.findMediaByModelCode(modelCode));
        return mapper.map(medias);
    }

    @Override
    public Media saveMedia(Media media) {
        return mapper.map(mediaRepository.save(mapper.map(media).setNewMedia(true)));
    }

    @Override
    public String deleteMediaByModelCode(String modelCode) {
        mediaRepository.deleteAllByModelCode(modelCode);
        log.info("all media files has been deleted by model code: {}", modelCode);
        return "OK";
    }
}
