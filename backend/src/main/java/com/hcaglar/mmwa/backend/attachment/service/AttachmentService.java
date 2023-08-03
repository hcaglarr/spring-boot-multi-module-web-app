package com.hcaglar.mmwa.backend.attachment.service;

import com.hcaglar.mmwa.backend.attachment.entity.Attachment;
import com.hcaglar.mmwa.backend.attachment.repository.AttachmentRepository;
import com.hcaglar.mmwa.common.repository.BaseRepository;
import com.hcaglar.mmwa.common.service.BaseRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttachmentService extends BaseRestService<Attachment, String> {

    private final AttachmentRepository attachmentRepository;


    @Override
    public BaseRepository<Attachment, String> getRepository() {
        return attachmentRepository;
    }

}