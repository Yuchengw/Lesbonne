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
	private Collection<AskingPost> askingPosts;
	private Collection<SharingPost> sharingPosts;
	private Collection<Order> orders;
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

	public boolean isEmailAuthorized() {
		return isEmailAuthorized;
	}

	public void setEmailAuthorized(boolean isEmailAuthorized) {
		this.isEmailAuthorized = isEmailAuthorized;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	public String getUsername() {
		return userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return accountEnabled;
	}
	
	public boolean isAccountEnabled() {
		return accountEnabled;
	}

	public void setAccountEnabled(boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
	}
	
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	
	public void setEnabled(boolean enabled) {
	}
	
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
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
		
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
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
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getUsername();
	}

	@Override
	public String getPassword() {
		/**
		 * Add this getter for UserDetail service.
		 * */
		return this.userPassword;
	}
}

