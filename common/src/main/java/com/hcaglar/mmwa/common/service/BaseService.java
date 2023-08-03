package com.hcaglar.mmwa.common.service;

import com.hcaglar.mmwa.common.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

import static com.hcaglar.mmwa.common.constant.ExceptionMessageConstant.NOT_FOUND;


@RequiredArgsConstructor
public abstract class BaseService<Entity, ID> extends BaseServiceProxy<Entity, ID, BaseRepository<Entity, ID>> {

    public Entity get(ID entityId) {
        return this.getRepository().findById(entityId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND));
    }

    public Entity save(Entity entity) {
        savePreHandler(entity);
        Entity newRegisteredEntity = this.getRepository().save(entity);
        saveAfterHandler(newRegisteredEntity);
        return newRegisteredEntity;
    }

    public Entity update(Entity entity, ID entityId) {
        putPreHandler(entity);
        Entity updatedEntity = save(entity);
        putAfterHandler(entity);
        return updatedEntity;
    }

    public void delete(Entity entity) {
        deletePreHandler(entity);
        this.getRepository().delete(entity);
    }

    public void savePreHandler(Entity entity) {
    }

    public void putPreHandler(Entity entity) {
    }

    public void saveAfterHandler(Entity entity) {
    }

    public void putAfterHandler(Entity entity) {
    }

    public void deletePreHandler(Entity entity) {
    }

}
