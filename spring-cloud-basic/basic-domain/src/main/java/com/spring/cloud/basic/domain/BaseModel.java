package com.spring.cloud.basic.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
class BaseModel implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    private Date createTime;

    @CreatedBy
    private String createName;

    @LastModifiedDate
    private Date lastChangeTime;

    @LastModifiedBy
    private String updateName;
}