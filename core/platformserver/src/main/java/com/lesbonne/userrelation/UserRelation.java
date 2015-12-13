package com.lesbonne.userrelation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lesbonne.user.User;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name="USERRELATION")
public class UserRelation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6113029977740096433L;

	@Id 
	@Column(name="PARTNERID", columnDefinition="VARCHAR(18) NOT NULL")
	private long userRelationId;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERID", referencedColumnName = "USERID", insertable=false, updatable=false)
	private User userRelation1;
	
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
	
	public User getUserRelation1() {
		return userRelation1;
	}
	
	public void setUserRelation1(User userRelation1) {
		this.userRelation1 = userRelation1;
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
