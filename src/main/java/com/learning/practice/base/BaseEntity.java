package com.learning.practice.base;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity<T> implements Serializable, IEntity {
    private static final long serialVersionUID = -4972120468540966454L;
    private T id;
    private String createUser;
    private String updateUser;

    private Date createTime;

    private Date updateTime;

    public BaseEntity() {
    }

    public T getId() {
        return this.id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

