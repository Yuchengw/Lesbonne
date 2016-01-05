package com.lesbonne.business.bean;

/**
 * @author yucheng
 * @since 1
 * */
public enum UserRole {
	
	USER, ADMIN, ANONYMOUS, DBA;
	
	/**
	 * 
	 * */
	public UserAuthority asAuthorityFor(final User user) {
		final UserAuthority authority = new UserAuthority();
		authority.setAuthority("ROLE_" + toString());
		authority.setUser(user);
		return authority;
	}
	
	/**
	 * 
	 * */
	public static UserRole valueOf(final UserAuthority authority) {
		switch (authority.getAuthority()) {
			case "ROLE_USER":
				return USER;
			case "ROLE_ADMIN":
				return ADMIN;
			case "ROLE_ANONYMOUS":
				return ANONYMOUS;
			case "ROLE_DBA":
				return DBA;
		}
		throw new IllegalArgumentException("No role defined for authority: " + authority.getAuthority());
	}
}
