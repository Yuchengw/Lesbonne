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
	
	@Column(name = "USERID1", columnDefinition="VARCHAR(18) NOT NULL")
	/**
	 * This could be the followee in the follow context.,etc
	 * */
	private String userId1; 
	
	@Column(name = "USERID2", columnDefinition="VARCHAR(18) NOT NULL")
	private String userId2;
	
	@Column(name = "CREATEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdTime;
	
	@Column(name = "LASTMODIFIEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedTime;
	
	public long getUserRelationId() {
		return userRelationId;
	}
	
	public String getUserId1() {
		return userId1;
	}
	
	public void setUserId1(String userId1) {
		this.userId1 = userId1;
	}
	
	public String getUserId2() {
		return userId2;
	}
	
	public void setUserId2(String userId2) {
		this.userId2 = userId2;
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
