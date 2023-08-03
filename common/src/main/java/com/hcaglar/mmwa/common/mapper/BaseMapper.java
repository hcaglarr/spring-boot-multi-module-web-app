package com.hcaglar.mmwa.common.mapper;

import java.util.List;

public interface BaseMapper<T, S, U, P> {

    U toEntity(T request);

    S toResponse(U entity);

    List<S> toEntites(List<U> entities);

    List<P> toPageables(List<U> pageables);
}
