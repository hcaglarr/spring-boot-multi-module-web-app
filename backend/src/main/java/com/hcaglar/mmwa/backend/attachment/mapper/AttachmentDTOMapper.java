package com.hcaglar.mmwa.backend.attachment.mapper;

import com.hcaglar.mmwa.backend.attachment.dto.request.AttachmentDTORequest;
import com.hcaglar.mmwa.backend.attachment.dto.response.AttachmentDTOResponse;
import com.hcaglar.mmwa.backend.attachment.entity.Attachment;
import com.hcaglar.mmwa.common.dto.response.PageableDTOResponse;
import com.hcaglar.mmwa.common.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.InjectionStrategy.FIELD;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, uses = {AttachmentDTOMapper.class}, injectionStrategy = FIELD)
public interface AttachmentDTOMapper extends BaseMapper<AttachmentDTORequest, AttachmentDTOResponse, Attachment, PageableDTOResponse<AttachmentDTOResponse>> {

    @Mapping(source = "data", target = "data")
    @Override
    Attachment toEntity(AttachmentDTORequest request);

}
