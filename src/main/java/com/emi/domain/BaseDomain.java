package com.emi.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by emi on 2016/11/1.
 */
@MappedSuperclass//父类  不需要生成表， 但子类生成的表包含该类的属性
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDomain implements Serializable {

    @CreatedDate//①：Application上添加@EnableJpaAuditing， ②class上添加@EntityListeners(AuditingEntityListener.class)
    private Date createTime;

    @LastModifiedDate
    private Date lastUpdateTime;

    @Column(nullable = true)
    private boolean ifDelete;

    public BaseDomain() {
        this.createTime = new Date();
        this.lastUpdateTime = this.createTime;
        this.ifDelete = false;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public boolean isIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(boolean ifDelete) {
        this.ifDelete = ifDelete;
    }
}
