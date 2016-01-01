package com.lesbonne.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.order.Order;
import com.lesbonne.partner.Partner;
import com.lesbonne.sharingpost.SharingPost;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name="LESBONNEUSER")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USERID", nullable = false, unique = true, columnDefinition = "VARCHAR(18)")
	@GenericGenerator(strategy="com.lesbonne.mysqldb.DBIdGenerator",name="userIdGenerator",
					parameters = {@Parameter(name = "prefix", value = "001")})
	@GeneratedValue(generator="userIdGenerator")
	private String userId;
	
	@Column(name = "USEREMAIL", unique = true, columnDefinition = "VARCHAR(511) NOT NULL")
	private String userEmail;
	
	@Column(name = "USERPASSWORD", columnDefinition = "VARCHAR(255) NOT NULL")
	private String userPassword;
	
	@Column(name = "USERROLE", columnDefinition = "TINYINT NOT NULL")
	private int UserRole;
	
	@Column(name = "ISEMAILAUTHORIZED", columnDefinition = "BOOLEAN")
	private Boolean isEmailAuthorized;
	
	@Column(name = "ACCOUNTNONEXPIRED", columnDefinition = "BOOLEAN")
	private Boolean accountNonExpired;
	
	@Column(name = "ACCOUNTNONLOCKED",  columnDefinition = "BOOLEAN")
	private Boolean accountNonLocked;
	
	@Column(name = "ACCOUNTENABLED", columnDefinition = "BOOLEAN")
	private Boolean accountEnabled;
	
	@Column(name = "CREDENTIALSNONEXPIRED", columnDefinition = "BOOLEAN")
	private Boolean credentialsNonExpired;
	
	@Column(name = "USERCONTACTINFO", columnDefinition = "MEDIUMTEXT")
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
	
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	private List<AskingPost> askingPosts;

	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	private List<SharingPost> sharingPosts;
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	private List<Order> orders;
	
	@OneToMany(mappedBy = "userPartner1", fetch = FetchType.LAZY)
	private List<Partner> partners;

	/*========== Getters and Setters. ==========*/
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getUserRole() {
		return UserRole;
	}

	public void setUserType(int userType) {
		UserRole = userType;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean getAccountEnabled() {
		return accountEnabled;
	}

	public void setAccountEnabled(Boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setUserRole(int userRole) {
		UserRole = userRole;
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
	
	public List<AskingPost> getAskingPosts() {
		return askingPosts;
	}

	public void setAskingPosts(List<AskingPost> askingPosts) {
		this.askingPosts = askingPosts;
	}
	
	public List<SharingPost> getSharingPosts() {
		return sharingPosts;
	}

	public void setSharingPosts(List<SharingPost> sharingPosts) {
		this.sharingPosts = sharingPosts;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}

