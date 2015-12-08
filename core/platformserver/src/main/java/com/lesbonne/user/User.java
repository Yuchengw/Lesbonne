package com.lesbonne.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name = "USER")
public class User {
	/**
	 * PLEASE Use Mysql statements Define DDL.
	 * */
	@Id
	@Column(name = "USERID", columnDefinition = "VARCHAR(18) NOT NULL")
	private String userId;

	@Column(name = "USERTYPE", columnDefinition = "TINYINT NOT NULL")
	private int UserType;
	
	@Column(name = "USEREMAIL", columnDefinition = "VARCHAR(511) NOT NULL")
	private String userEmail;
	
	@Column(name = "ISEMAILAUTHORIZED", columnDefinition = "BOOLEAN")
	private Boolean isEmailAuthorized;
	
	@Column(name = "USERPASSWORD", columnDefinition = "VARCHAR(255) NOT NULL")
	private String userPassword;
	
	@Column(name = "USERCONTACTINFO", columnDefinition = "MEDIUMTEXT NOT NULL")
	private String userContactInfo;
	
	@Column(name = "USERRELATIONID", columnDefinition = "VARCHAR(18)")
	private String userRelationId;
	
	@Column(name = "CREATEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	private String createdTime;
	
	@Column(name = "LASTMODIFIEDTIME", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String lastModifiedTime;
	
	/*========== Foreign Key Starts From Here. ==========*/
	@Column(name = "USERPAYMENTID", columnDefinition="VARCHAR(18)")
	private String userPaymentId;
	
	/*========== Getters and Setters. ==========*/
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getUserType() {
		return UserType;
	}

	public void setUserType(int userType) {
		UserType = userType;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Boolean getIsEmailAuthorized() {
		return isEmailAuthorized;
	}

	public void setIsEmailAuthorized(Boolean isEmailAuthorized) {
		this.isEmailAuthorized = isEmailAuthorized;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserContactInfo() {
		return userContactInfo;
	}

	public void setUserContactInfo(String userContactInfo) {
		this.userContactInfo = userContactInfo;
	}

	public String getUserRelationId() {
		return userRelationId;
	}

	public void setUserRelationId(String userRelationId) {
		this.userRelationId = userRelationId;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public String getUserPaymentId() {
		return userPaymentId;
	}

	public void setUserPaymentId(String userPaymentId) {
		this.userPaymentId = userPaymentId;
	}
}

