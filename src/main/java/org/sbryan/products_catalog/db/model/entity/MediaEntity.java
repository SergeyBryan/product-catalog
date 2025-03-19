package org.sbryan.products_catalog.db.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("media")
@Builder
@Getter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class MediaEntity extends AbstractEntity implements Persistable<UUID> {

    @Id
    @Column("media_uuid")
    private UUID uuid;
    @Column("model_code")
    private String modelCode;
    @Column("sort_order")
    private Integer sortOrder;
    @Column("media")
    private byte[] media;

    @Transient
    @Setter
    private boolean isNewMedia;

    @Override
    public UUID getId() {
        return uuid;
    }

    public boolean isNew() {
        return this.isNewMedia || this.uuid != null;
    }
}
