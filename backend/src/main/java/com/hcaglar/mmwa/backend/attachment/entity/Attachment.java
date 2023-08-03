package com.hcaglar.mmwa.backend.attachment.entity;


import com.hcaglar.mmwa.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import static com.hcaglar.mmwa.common.constant.EntityConstant.*;


@Getter
@Setter
@Entity
@Table(name = ATTACHMENTS, indexes = {@Index(name = INDEX_ATTACHMENT, columnList = ID, unique = true)})
public class Attachment extends BaseEntity {

    @Id
    @UuidGenerator
    private String id;

    private String name;

    private String type;

    @Lob
    @Column(columnDefinition = TEXT)
    private String text;

    @Lob
    @Column(columnDefinition = TEXT)
    private String title;

    @Lob
    @Column(columnDefinition = TEXT)
    private String subtitle;

    @Lob
    @Column(columnDefinition = TEXT)
    private String description;

    @Lob
    @Column(columnDefinition = TEXT)
    private byte[] data;

}
