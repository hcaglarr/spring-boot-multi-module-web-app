package com.hcaglar.mmwa.common.util;


import com.hcaglar.mmwa.common.entity.BaseEntity;

public class BaseEntityUtil {

    public static void swap(BaseEntity fromEntity, BaseEntity toEntity){
        toEntity.setCreateAt(fromEntity.getCreateAt());
        toEntity.setCreatedBy(fromEntity.getCreatedBy());
        toEntity.setUpdateAt(fromEntity.getUpdateAt());
        toEntity.setUpdatedBy(fromEntity.getUpdatedBy());
        toEntity.setDeleteAt(fromEntity.getDeleteAt());
        toEntity.setDeletedBy(fromEntity.getDeletedBy());
    }

}
