package com.lesbonne.business.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.lesbonne.web.security.UserAuthentication;
import com.lesbonne.web.security.LesbonneUserDetailsService;

/**
 * @author yucheng
 * @version 1
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BeanObject implements UserDetails, Serializable {

	private static final long serialVersionUID = -7788619177798333712L;
	
	@JsonProperty("userId")
	private String userId;
	@JsonProperty("userEmail")
	private String userEmail;
	@JsonProperty("userPassword")
	private String userPassword;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("userContactInfo")
	private String userContactInfo;
	@JsonProperty("userRelationId")
	private String userRelationId;
	@JsonProperty("userPaymentId")
	private String userPaymentId;
	@JsonProperty("userRole")
	private int userRole;
	@JsonProperty("isEmailAuthorized")
	private boolean isEmailAuthorized;
	@JsonProperty("accountNonExpired")
	private boolean accountNonExpired;
	@JsonProperty("accountNonLocked")
	private boolean accountNonLocked;
	@JsonProperty("credentialsNonExpired")
	private boolean credentialsNonExpired;
	@JsonProperty("accountEnabled")
	private boolean accountEnabled;
	@JsonProperty("askingPosts")
	private Collection<AskingPost> askingPosts;
	@JsonProperty("sharingPosts")
	private Collection<SharingPost> sharingPosts;
	@JsonProperty("orders")
	private Collection<Order> orders;
	@JsonProperty("partners")
	private Collection<Partner> partners;

	private Set<UserAuthority> authorities;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
		super.setId(userId);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public boolean getIsEmailAuthorized() {
		return isEmailAuthorized;
	}

	public void setIsEmailAuthorized(boolean isEmailAuthorized) {
		this.isEmailAuthorized = isEmailAuthorized;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public boolean getAccountNonExpired() {
		return this.accountNonExpired;
	}
	
	public void setAccountNonExpired(boolean expired) {
		this.accountNonExpired = expired;
	}
	
	public boolean getAccountNonLocked() {
		return this.accountNonLocked;
	}
	
	public void setAccountNonLocked(boolean locked) {
		this.accountNonLocked = locked;
	}
	
	public boolean getCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}
	
	public void setCredentialsNonExpired(boolean expired) {
		this.credentialsNonExpired = expired;
	}
	
	public boolean getAccountEnabled() {
		return this.accountEnabled;
	}
	
	public void setAccountEnabled(boolean enabled) {
		this.accountEnabled = enabled;
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
	
	public Collection<AskingPost> getAskingPosts() {
		return askingPosts;
	}

	public void setAskingPosts(Collection<AskingPost> askingPosts) {
		this.askingPosts = askingPosts;
	}

	public Collection<SharingPost> getSharingPosts() {
		return sharingPosts;
	}

	public void setSharingPosts(Collection<SharingPost> sharingPosts) {
		this.sharingPosts = sharingPosts;
	}

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}

	public Collection<Partner> getPartners() {
		return partners;
	}

	public void setPartners(Collection<Partner> partners) {
		this.partners = partners;
	}

	public static User getInstance() {
		return getInstance(false);
	}

	public Set<UserRole> getRoles() {
		Set<UserRole> roles = EnumSet.noneOf(UserRole.class);
		if (authorities != null) {
			for (UserAuthority authority : authorities) {
				roles.add(UserRole.valueOf(authority));
			}
		}
		return roles;
	}
	
	public void setRoles(Set<UserRole> roles) {
		for (UserRole role : roles) {
			grantRole(role);
		}
	}

	public void grantRole(UserRole role) {
		if (authorities == null) {
			authorities = new HashSet<UserAuthority>();
		}
		authorities.add(role.asAuthorityFor(this));
	}
	
	public void revokeRole(UserRole role) {
		if (authorities != null) {
			authorities.remove(role.asAuthorityFor(this));
		}
	}

	public boolean hasRole(UserRole role) {
		return authorities.contains(role.asAuthorityFor(this));
	}
	
	public static User getInstance(boolean allowInactiveUser) {
		// TODO: need to add cache for better performance.
		UserAuthentication userAuth = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
		if (userAuth == null) {
			//TODO: add proper exception;
		}
		LesbonneUserDetailsService userDetailsService = new LesbonneUserDetailsService();
		User user = userDetailsService.loadUserByUsername(userAuth.getName());
		return user;
	}
	
	//============================For UserDetail Service=======================//
	@Override
	public String getUsername() {
		return getUserEmail();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return getAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return getAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return getCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return getAccountEnabled();
	}
	
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getUsername();
	}

	@Override
	public String getPassword() {
		return getUserPassword();
	}
}

