package com.lesbonne.api.rest;

import com.lesbonne.business.bean.User;

/**
 * @author yucheng
 * @since 1
 * */
@SuppressWarnings("rawtypes")
public class AppRestUserClientImpl extends RestClient {

	private static final String REST_USER_PREFIX = "/user";
	
	@SuppressWarnings("unchecked")
	public AppRestUserClientImpl(Class expectedType) {
		super(expectedType);
	}

	public User getUserByEmail(String email) {
		User user = (User) doGet(REST_USER_PREFIX + "/" + email);
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public User createUser(User u) {
		User user = (User) doPost(REST_USER_PREFIX + "/create", u);
		return user;
	}
		
	@SuppressWarnings("unchecked")
	public User updateUser(User u) {
		User user = (User) doPost(REST_USER_PREFIX + "/update", u);
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public User deleteUser(User deleteUser) {
		User returnUser = (User) doPost(REST_USER_PREFIX + "/delete/", deleteUser.getUserId());
		return returnUser;
	}
}
