package com.hcaglar.mmwa.common.response;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

public abstract class BaseResponseEntity<Response> {

    protected ResponseEntity.BodyBuilder responseEntity() {
        return ResponseEntity.ok();
    }

    protected ResponseEntity<HttpStatus> responseEntity(HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).build();
    }

    protected ResponseEntity<PageImpl<Response>> responseEntity(PageImpl<Response> responsePage) {
        return ResponseEntity.ok(responsePage);
    }


    protected ResponseEntity<Response> responseEntity(Response response) {
        return ResponseEntity.ok(response);
    }

    protected ResponseEntity<List<Response>> responseEntity(List<Response> responses) {
        return ResponseEntity.ok(responses);
    }

    protected ResponseEntity<Response> responseEntity(Response response, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).body(response);
    }

    protected ResponseEntity<ByteArrayResource> responseEntity(ByteArrayResource byteArrayResource, String fileName) {
        final var responseEntity = ResponseEntity.ok(byteArrayResource);
        responseEntity.getHeaders().put(CONTENT_DISPOSITION, singletonList(String.format("attachment; filename=%s", fileName)));
        return responseEntity;
    }

}
