package com.lesbonne.api.rest;

import com.lesbonne.business.bean.User;

/**
 * @author yucheng
 * @since 1
 * */
@SuppressWarnings("rawtypes")
public class AppRestUserClientImpl extends RestClient {

	private static final String REST_USER_PREFIX = "user";
	
	@SuppressWarnings("unchecked")
	public AppRestUserClientImpl(Class expectedType) {
		super(expectedType);
	}

	public User getUserByEmail(String email) {
		return (User) doGet(REST_USER_PREFIX + "/" + email);
	}
	
	@SuppressWarnings("unchecked")
	public User createUser(User u) {
		return (User) doPost(REST_USER_PREFIX + "/create", u);
	}
		
	@SuppressWarnings("unchecked")
	public User updateUser(User u) {
		return (User) doPost(REST_USER_PREFIX + "/update", u);
	}
	
	@SuppressWarnings("unchecked")
	public User deleteUser(User deleteUser) {
		return (User) doPost(REST_USER_PREFIX + "/delete/", deleteUser.getUserId());
	}
	
	@SuppressWarnings("unchecked")
	public boolean existsUserByEmail(String userEmail) {
		return (Boolean) doGet(REST_USER_PREFIX + "/existsUserByEmail/" + userEmail);
	}
}
