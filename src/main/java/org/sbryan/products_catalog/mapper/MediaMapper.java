package org.sbryan.products_catalog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.sbryan.products_catalog.codegen.types.Media;
import org.sbryan.products_catalog.db.model.entity.MediaEntity;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface MediaMapper {

    @Mapping(target = "mediaUuid", expression = "java(source.getUuid().toString())")
    @Mapping(target = "image", expression = "java(mapMedia(source.getMedia()))")
    Media map(MediaEntity source);

    @Mapping(target = "media", expression = "java(mapMedia(source.getImage()))")
    @Mapping(target = "uuid", expression = "java(UUID.randomUUID())")
    MediaEntity map(Media source);

    List<Media> map(List<MediaEntity> source);

    default byte[] mapMedia(String media) {
        return Base64.getDecoder().decode(media);
    }

    default String mapMedia(byte[] base64) {
        return Base64.getEncoder().encodeToString(base64);
    }

}
