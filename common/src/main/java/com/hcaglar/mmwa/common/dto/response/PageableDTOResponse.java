package com.hcaglar.mmwa.common.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageableDTOResponse<ResponseDTO> {

    private List<ResponseDTO> content;

    private Integer totalPages;

    private Integer number;

    private Integer size;

    private Integer numberOfElements;

    private Long totalElements;

    private Boolean hasNext;

    private Boolean isLast;


    public Boolean hasNext() {
        return hasNext;
    }

    public void hasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Boolean getLast() {
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

}
