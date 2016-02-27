package com.lesbonne.api.rest;

import com.lesbonne.business.bean.User;

/**
 * @author yucheng
 * @since 1
 * */
public class AppRestUserClientImpl extends RestClient<User, Object> {

	private static final String REST_USER_PREFIX = "user";
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AppRestUserClientImpl(Class expectedType) {
		super(expectedType);
	}

	public User getUserByEmail(String email) {
		return (User) doGet(REST_USER_PREFIX + "/getUserByEmail/" + email);
	}
	
	public User getUserById(String userId) {
		return (User) doGet(REST_USER_PREFIX + "/id/" + userId);
	}
	
	public User createUser(User u) {
		return (User) doPost(REST_USER_PREFIX + "/create", u);
	}
		
	public User updateUser(User u) {
		return (User) doPost(REST_USER_PREFIX + "/update", u);
	}
	
	public boolean deleteUser(User deleteUser) {
		return (boolean) doPost(REST_USER_PREFIX + "/delete/", deleteUser);
	}
	
	public boolean existsUserByEmail(String userEmail) {
		return (Boolean) doGet(REST_USER_PREFIX + "/existsUserByEmail/" + userEmail);
	}
	
	public boolean existsUserByid(String userId) {
		return (Boolean) doGet(REST_USER_PREFIX + "/existsUserById/" + userId);
	}
}
