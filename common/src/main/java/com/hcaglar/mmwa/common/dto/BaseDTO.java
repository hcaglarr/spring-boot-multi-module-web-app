package com.hcaglar.mmwa.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public abstract class BaseDTO implements Serializable {

    private Date createdOn;

    private Date lastChangedOn;

    private String createdByUser;

    private String lastChangedByUser;

    private Date deletedAt;

}
