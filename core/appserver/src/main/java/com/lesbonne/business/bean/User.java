package com.lesbonne.business.bean;

import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lesbonne.web.security.UserAuthentication;
import com.lesbonne.web.security.UserDetailsService;

/**
 * @author yucheng
 * @version 1
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BeanObject implements UserDetails {

	private static final long serialVersionUID = -7788619177798333712L;

	private String userId;
	private String userEmail;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private boolean isEmailAuthorized;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean accountEnabled;

	private Set<UserAuthority> authorities;

	public User() {
	}

	public User(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public User(String id, String userEmail,String firstName, String lastName) {
		super.setId(id);
		this.userEmail = userEmail;
		this.firstName = firstName;
		this.lastName = lastName;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	// Use Roles as external API
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
		UserDetailsService userDetailsService = new UserDetailsService();
		User user = userDetailsService.loadUserByUsername(userAuth.getName());
		return user;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + getUsername();
	}
}
