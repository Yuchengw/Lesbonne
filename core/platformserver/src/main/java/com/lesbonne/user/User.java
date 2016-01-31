package com.lesbonne.user;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.entity.CommonEntityInfo;
import com.lesbonne.entity.EntityBean;
import com.lesbonne.order.Order;
import com.lesbonne.partner.Partner;
import com.lesbonne.sharingpost.SharingPost;

/**
 * @author yucheng
 * @since 1
 * */
@Entity
@Table(name = "LESBONNEUSER")
public class User extends CommonEntityInfo implements EntityBean, Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(
            name = "USERID", nullable = false, unique = true,
            columnDefinition = "VARCHAR(18)")
    @GenericGenerator(
            strategy = "com.lesbonne.mysqldb.DBIdGenerator",
            name = "userIdGenerator", parameters = { @Parameter(
                    name = "prefix", value = "001") })
    @GeneratedValue(generator = "userIdGenerator")
    private String userId;
    
    @Column(
            name = "USEREMAIL", unique = true,
            columnDefinition = "VARCHAR(511) NOT NULL")
    private String userEmail;
    
    @Column(name = "USERPASSWORD", columnDefinition = "VARCHAR(255) NOT NULL")
    private String userPassword;
    
    @Column(name = "USERROLE", columnDefinition = "TINYINT NOT NULL")
    private int UserRole;
    
    @Column(name = "ISEMAILAUTHORIZED", columnDefinition = "BOOLEAN")
    private Boolean isEmailAuthorized;
    
    @Column(name = "USERACCOUNTNONEXPIRED", columnDefinition = "BOOLEAN")
    private Boolean userAccountNonExpired;
    
    @Column(name = "USERACCOUNTNONLOCKED", columnDefinition = "BOOLEAN")
    private Boolean userAccountNonLocked;
    
    @Column(name = "USERACCOUNTENABLED", columnDefinition = "BOOLEAN")
    private Boolean userAccountEnabled;
    
    @Column(name = "USERCREDENTIALSNONEXPIRED", columnDefinition = "BOOLEAN")
    private Boolean userCredentialsNonExpired;
    
    @Column(name = "USERCONTACTINFO", columnDefinition = "MEDIUMTEXT")
    private String userContactInfo;
    
    @Column(name = "USERRELATIONID", columnDefinition = "VARCHAR(18)")
    private String userRelationId;
    
    /* ========== Foreign Key Starts From Here. ========== */
    @OneToMany(
            mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = SharingPost.class)
    @JsonManagedReference
    private Set<SharingPost> sharingPosts;
    
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<AskingPost> askingPosts;
    
    @Column(name = "USERPAYMENTID", columnDefinition = "VARCHAR(18)")
    private String userPaymentId;
    
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<Order> orders;
    
    @OneToMany(mappedBy = "userPartner1", fetch = FetchType.LAZY)
    private List<Partner> partners;
    
    /* ========== Getters and Setters. ========== */
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
    
    public Boolean getUserAccountNonExpired() {
        return userAccountNonExpired;
    }
    
    public void setUserAccountNonExpired(Boolean accountNonExpired) {
        this.userAccountNonExpired = accountNonExpired;
    }
    
    public Boolean getUserAccountNonLocked() {
        return userAccountNonLocked;
    }
    
    public void setUserAccountNonLocked(Boolean accountNonLocked) {
        this.userAccountNonLocked = accountNonLocked;
    }
    
    public Boolean getUserAccountEnabled() {
        return userAccountEnabled;
    }
    
    public void setUserAccountEnabled(Boolean accountEnabled) {
        this.userAccountEnabled = accountEnabled;
    }
    
    public Boolean getUserCredentialsNonExpired() {
        return userCredentialsNonExpired;
    }
    
    public void setUserCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.userCredentialsNonExpired = credentialsNonExpired;
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
    
    public Set<SharingPost> getSharingPosts() {
        return sharingPosts;
    }
    
    public void setSharingPosts(Set<SharingPost> sharingPosts) {
        this.sharingPosts = sharingPosts;
    }
    
    public List<Order> getOrders() {
        return orders;
    }
    
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    @Override
    public Map<String, Object> getIndexedColumns() {
        Map<String, Object> searchableColumns = new HashMap<String, Object>();
        searchableColumns.put("email", getUserEmail());
        return searchableColumns;
    }
    
    @Override
    public String getId() {
        return getUserId();
    }
    
    public String toString() {
        return "{" + "\"userEmail\":\"" + getUserEmail() + "\","
                + "\"userPassword\":\"" + getUserPassword() + "\"}";
    }
}
