package com.lesbonne.userrelation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name = "USERRELATION")
public class UserRelation {
	
	@Id @GeneratedValue 
	/**
	 * Primary Key
	 * */
	private long userRelationId;	
	
	@Column(name = "ID1", columnDefinition="VARCHAR(18) NOT NULL")
	/**
	 * This the UserId.
	 * */
	private String id1; 
	
	@Column(name = "ID2", columnDefinition="VARCHAR(18) NOT NULL")
	/**
	 * User could follow User/Post/...
	 * */
	private String id2;
	
	@Column(name = "CREATEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdTime;
	
	@Column(name = "LASTMODIFIEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedTime;
	
	public long getUserRelationId() {
		return userRelationId;
	}
	
	public String getId1() {
		return id1;
	}
	
	public void setid1(String id1) {
		this.id1 = id1;
	}
	
	public String getId2() {
		return id2;
	}
	
	public void setUserId2(String id2) {
		this.id2 = id2;
	}
	
	public String getCreatedTime() {
		return createdTime;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
