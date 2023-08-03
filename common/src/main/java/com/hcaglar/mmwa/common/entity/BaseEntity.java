package com.hcaglar.mmwa.common.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

import static com.hcaglar.mmwa.common.constant.EntityConstant.CREATED_AT;
import static com.hcaglar.mmwa.common.constant.EntityConstant.UPDATED_AT;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @CreatedDate
    @Column(name = CREATED_AT)
    private Date createAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    @Column(name = UPDATED_AT)
    private Date updateAt;

    @LastModifiedBy
    private String updatedBy;

    private Date deleteAt;

    private String deletedBy;

}
