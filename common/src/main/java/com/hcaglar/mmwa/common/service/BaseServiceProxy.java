package com.hcaglar.mmwa.common.service;


import com.hcaglar.mmwa.common.repository.BaseRepository;

public abstract class BaseServiceProxy<T, I,  R extends BaseRepository<T, I>> {

   public abstract R getRepository();

}
