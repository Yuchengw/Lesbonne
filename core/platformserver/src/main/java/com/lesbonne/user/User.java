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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lesbonne.askingpost.AskingPost;
import com.lesbonne.entity.CommonEntityInfo;
import com.lesbonne.entity.EntityBean;
import com.lesbonne.order.Order;
import com.lesbonne.partner.Partner;
import com.lesbonne.paymentmethod.PaymentMethod;
import com.lesbonne.postcomment.PostComment;
import com.lesbonne.promotion.PromotionCode;
import com.lesbonne.promotionusage.PromotionUsage;
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
    
    @Column(name = "USERNAME", columnDefinition = "VARCHAR(255) NOT NULL")
    private String userName;
    
    @Column(name= "USERPROFILEIMAGE", columnDefinition = "VARCHAR(725) NOT NULL")
    private String userProfileImage;
    
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
    
    @Column(name = "USERPAYMENTID", columnDefinition = "VARCHAR(18)")
    private String userPaymentId;
    
    /* ========== Foreign Key Starts From Here. ========== */
    @OneToMany(
            mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = SharingPost.class)
    @JsonManagedReference(value="user-sharingpost")
    private Set<SharingPost> sharingPosts;
    
    @OneToMany(
            mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = AskingPost.class)
    @JsonManagedReference(value="user-askingpost")
    private Set<AskingPost> askingPosts;
    
    @OneToMany(
            mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = PostComment.class)
    @JsonManagedReference(value="user-postcomment")
    private Set<PostComment> postComments;
    
    @OneToMany(
            mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = PromotionCode.class)
    @JsonManagedReference(value="user-promotion")
    private Set<PromotionCode> promotionCodes;
    
    @OneToMany(
            mappedBy = "usedBy", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = PromotionUsage.class)
    @JsonManagedReference(value="user-promotionusage")
    private Set<PromotionUsage> promotionUsages;
    
    @OneToMany(
            mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = Order.class)
    @JsonManagedReference(value="user-order")
    private Set<Order> orders;
    
    @OneToMany(
            mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL }, targetEntity = PaymentMethod.class)
    @JsonManagedReference(value="user-paymentmethod")
    private Set<PaymentMethod> paymentMethods;
    
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
    
    public String getUserName() {
    	return userName;
    }
    
    public void setUserName(String userName) {
    	this.userName = userName;
    }
    
    public String getUserProfileImage() {
    	return userProfileImage;
    }
    
    public void setUserProfileImage(String userProfileImage) {
    	this.userProfileImage = userProfileImage;
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
    
    public Set<AskingPost> getAskingPosts() {
        return askingPosts;
    }
    
    public void setAskingPosts(Set<AskingPost> askingPosts) {
        this.askingPosts = askingPosts;
    }
    
    public Set<SharingPost> getSharingPosts() {
        return sharingPosts;
    }
    
    public void setSharingPosts(Set<SharingPost> sharingPosts) {
        this.sharingPosts = sharingPosts;
    }
    
    public Set<PostComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(Set<PostComment> postComments) {
        this.postComments = postComments;
    }
    
    public Set<Order> getOrders() {
        return orders;
    }
    
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
    
    public Set<PromotionCode> getPromotionCodes() {
        return promotionCodes;
    }

    public void setPromotionCodes(Set<PromotionCode> promotionCodes) {
        this.promotionCodes = promotionCodes;
    }
    
    public Set<PromotionUsage> getPromotionUsages() {
        return promotionUsages;
    }

    public void setPromotionUsages(Set<PromotionUsage> promotionUsages) {
        this.promotionUsages = promotionUsages;
    }

    public Set<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Set<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    @Override
    public Map<String, Object> indexedColumns() {
        Map<String, Object> searchableColumns = new HashMap<String, Object>();
        searchableColumns.put("email", getUserEmail());
        return searchableColumns;
    }
    
    @Override
    public String id() {
        return getUserId();
    }
    
    public String toString() {
        return "{" + "\"userEmail\":\"" + getUserEmail() + "\","
                + "\"userPassword\":\"" + getUserPassword() + "\"}";
    }
}
