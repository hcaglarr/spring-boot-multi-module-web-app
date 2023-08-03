package com.hcaglar.mmwa.backend.attachment.dto.response;

import com.hcaglar.mmwa.common.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentDTOResponse extends BaseDTO {

    private String id;

    private String name;

    private String type;

    private String text;

    private String title;

    private String subtitle;

    private String description;

    private Long productId;

    private byte[] data;

}
