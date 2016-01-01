package com.lesbonne.user;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.GenericGenerator;

//import com.lesbonne.askingpost.AskingPost;
//import com.lesbonne.order.Order;
//import com.lesbonne.partner.Partner;
//import com.lesbonne.postcomment.PostComment;
//import com.lesbonne.sharingpost.SharingPost;

/**
 * @author yucheng
 * @since 1
 * @author jassica
 * @since 2
 * 
 * This class uses the javax.persistence annotations to be mapped to a table, LESBONNEUSER in the database. 
 * In particular, the @Entity annotation specifies that the class is an entity. 
 * The @Table annotation specifies the primary table for the annotated entity. 
 * The @Column annotation is used to specify a mapped column for the persistent field, whereas the @Id 
 * annotation specifies the primary key field of the entity.
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
	@GeneratedValue(generator="system-uuid")
    @GenericGenerator(strategy="com.lesbonne.utilities.DBIdGenerator",name="system-uuid",
    		parameters = {@Parameter(name = "prefix", value = "001")})
	private String userId;
	
	@Column(name = "USEREMAIL", nullable = false, unique = true, columnDefinition = "VARCHAR(510)")
	private String userEmail;
	
	@Column(name = "USERPASSWORD", nullable = false, columnDefinition = "VARCHAR(255)")
	private String userPassword;
	
	@Column(name = "USERROLE", columnDefinition = "TINYINT NOT NULL")
	private int UserRole;
	
	@Column(name = "ISEMAILAUTHORIZED", columnDefinition = "BOOLEAN")
	private Boolean isEmailAuthorized;
	
	/** Do we need these columns as they are already removed from app side 
	@Column(name = "ACCOUNTNONEXPIRED", columnDefinition = "BOOLEAN")
	private Boolean accountNonExpired;
	
	@Column(name = "ACCOUNTNONLOCKED",  columnDefinition = "BOOLEAN") 
	private Boolean accountNonLocked;
	
	@Column(name = "CREDENTIALSNONEXPIRED", columnDefinition = "BOOLEAN")
	private Boolean credentialsNonExpired;*/
	
	@Column(name = "ACCOUNTENABLED", columnDefinition = "BOOLEAN")
	private Boolean accountEnabled;
	
	@Column(name = "USERCONTACTINFO", nullable = false, columnDefinition = "BLOB")
	private String userContactInfo;
	
	@Column(name = "USERRELATIONID", columnDefinition = "VARCHAR(18)")
	private String userRelationId;
	
	@Column(name = "CREATEDTIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
//	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	@Column(name = "LASTMODIFIEDTIME", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date lastModifiedTime;

	/*========== Foreign Key Starts From Here. ==========*/
//	@Column(name = "USERPAYMENTID", columnDefinition="VARCHAR(18)")
//	private String userPaymentId;
	
//	@OneToMany(mappedBy = "owner")
//	private List<AskingPost> askingPosts;
//
//	@OneToMany(mappedBy = "owner")
//	private List<SharingPost> sharingPosts;
//	
//	@OneToMany(mappedBy = "owner")
//	private List<Order> orders;
//	
//	@OneToMany(mappedBy = "userPartner1")
//	private List<Partner> partners;

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

	/**public Boolean getAccountNonExpired() {
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
	
	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	*/

	public Boolean getAccountEnabled() {
		return accountEnabled;
	}

	public void setAccountEnabled(Boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
//
//	public String getUserPaymentId() {
//		return userPaymentId;
//	}
//
//	public void setUserPaymentId(String userPaymentId) {
//		this.userPaymentId = userPaymentId;
//	}
	
//	public List<AskingPost> getAskingPosts() {
//		return askingPosts;
//	}
//
//	public void setAskingPosts(List<AskingPost> askingPosts) {
//		this.askingPosts = askingPosts;
//	}
//	
//	public List<SharingPost> getSharingPosts() {
//		return sharingPosts;
//	}
//
//	public void setSharingPosts(List<SharingPost> sharingPosts) {
//		this.sharingPosts = sharingPosts;
//	}
//	
//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}
}

