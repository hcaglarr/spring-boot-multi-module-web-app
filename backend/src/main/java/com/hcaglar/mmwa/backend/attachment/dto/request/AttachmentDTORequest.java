package com.hcaglar.mmwa.backend.attachment.dto.request;

import com.hcaglar.mmwa.common.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentDTORequest extends BaseDTO {

    private String id;

    private String name;

    private String type;

    private String text;

    private String title;

    private String subtitle;

    private String description;

    private byte[] data;

    private Long productId;

}
