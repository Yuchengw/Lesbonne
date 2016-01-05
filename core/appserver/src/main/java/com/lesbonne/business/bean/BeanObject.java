package com.lesbonne.business.bean;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/**
 * @author yucheng
 * @since 1
 * */
public abstract class BeanObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 149762661465164766L;
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("createdTime")
	private Date createdTime;
	@JsonProperty("lastModifiedTime")
	private Date lastModifiedTime;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
    @JsonSerialize(using=DateSerializer.class)
	public Date getCreatedTime() {
		return createdTime;
	}
    
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
    @JsonSerialize(using=DateSerializer.class)
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
    
	public void setLastModifiedDate(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
