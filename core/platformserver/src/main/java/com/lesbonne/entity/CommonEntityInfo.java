package com.lesbonne.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lesbonne.utilities.CustomDateSerializer;

/**
 * The entity to hold all common fields
 * @author jassica
 *
 */
@MappedSuperclass
public abstract class CommonEntityInfo {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "CREATEDTIME",
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false)
    @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
    private Date createdTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "LASTMODIFIEDTIME",
            columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
            insertable = false, updatable = false)
    @org.hibernate.annotations.Generated(value = GenerationTime.ALWAYS)
    private Date lastModifiedTime;
    
    @PrePersist
    public void onCreate() {
        lastModifiedTime = createdTime = new Date();
    }
    
    @PreUpdate
    public void onUpdate() {
        lastModifiedTime = new Date();
    }
    
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreatedTime() {
        return createdTime;
    }
    
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }
    
    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}
