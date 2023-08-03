package com.hcaglar.mmwa.common.util;

import com.hcaglar.mmwa.common.pageable.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Objects;

public class PageableUtil {

    public static PageRequest createPageRequest(Pageable<?> pageable){

        if (Objects.nonNull(pageable.getSortName()) && pageable.isSortDirectionAsc()){
           return PageRequest.of(pageable.getPageNumber() -1, pageable.getPageSize(), Sort.Direction.ASC, pageable.getSortName());
        }

        if (Objects.nonNull(pageable.getSortName())){
            return PageRequest.of(pageable.getPageNumber() -1, pageable.getPageSize(), Sort.Direction.DESC, pageable.getSortName());
        }

        return PageRequest.of(pageable.getPageNumber() -1, pageable.getPageSize());
    }

}
