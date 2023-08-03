package com.hcaglar.mmwa.backend.attachment.controller;

import com.hcaglar.mmwa.backend.attachment.dto.request.AttachmentDTORequest;
import com.hcaglar.mmwa.backend.attachment.dto.response.AttachmentDTOResponse;
import com.hcaglar.mmwa.backend.attachment.entity.Attachment;
import com.hcaglar.mmwa.backend.attachment.mapper.AttachmentDTOMapper;
import com.hcaglar.mmwa.backend.attachment.repository.AttachmentRepository;
import com.hcaglar.mmwa.backend.attachment.service.AttachmentService;
import com.hcaglar.mmwa.common.controller.BaseRestController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


import static com.hcaglar.mmwa.common.constant.PathConstant.ATTACHMENTS;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {GET, POST, PUT})
@RestController
@RequestMapping(ATTACHMENTS)
@RequiredArgsConstructor
public class AttachmentController extends BaseRestController<String, Attachment, AttachmentDTORequest, AttachmentDTOResponse, AttachmentDTOMapper, AttachmentRepository, AttachmentService> {

    private final AttachmentService attachmentService;

    private final AttachmentDTOMapper attachmentDTOMapper;


    @Override
    protected AttachmentService getService() {
        return attachmentService;
    }

    @Override
    protected AttachmentDTOMapper getMapper() {
        return attachmentDTOMapper;
    }

    @PostMapping(consumes = {APPLICATION_JSON_VALUE, MULTIPART_FORM_DATA_VALUE})
    protected ResponseEntity<HttpStatus> save(@RequestPart(value = "request") AttachmentDTORequest attachmentDTORequest, @RequestPart("file") MultipartFile file) throws IOException {

        var attachment = attachmentDTOMapper.toEntity(attachmentDTORequest);

        attachment.setData(file.getBytes());
        attachment.setType(file.getContentType());

        attachmentService.save(attachment);

        return responseEntity(HttpStatus.CREATED);
    }

    @Override
    protected ResponseEntity<AttachmentDTOResponse> save(AttachmentDTORequest attachmentDTORequest) {
        return super.save(attachmentDTORequest);
    }

}
