package com.hcaglar.mmwa.common.pageable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pageable<T> {

    @NotNull
    @Min(1)
    private int pageNumber = 1;

    @NotNull
    @Min(1)
    private int pageSize = 10;

    private String sortName;

    private boolean sortDirectionAsc;

    T filter;

}
