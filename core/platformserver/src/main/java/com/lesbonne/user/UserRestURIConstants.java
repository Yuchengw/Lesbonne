package com.lesbonne.user;

/**
 * @author yucheng
 * @since 1
 * */
public class UserRestURIConstants {
	public static final String GET_USER_BY_EMAIL = "/platform/v1/user/email/{userEmail:.+}";
	public static final String GET_USER_BY_ID = "/platform/v1/user/id/{userId}";
	public static final String CREATE_USER = "/platform/v1/user/create";
	public static final String UPDATE_USER = "/platform/v1/user/update";
	public static final String DELETE_USER = "/platfrom/v1/user/delete/{userId}";
	public static final String EXISTS_USER_BY_EMAIL = "/platform/v1/user/existsUserByEmail/{userEmail}";
}
