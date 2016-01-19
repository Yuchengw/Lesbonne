package com.lesbonne.user;

/**
 * @author yucheng
 * @since 1
 * */
public interface UserService {
	
	User persistUser(User user);
	
	User getUserByEmail(String userEmail);
	
	User getUserById(String userId);
	
	User updateUser(User user);
	
	void deleteUser(User user);
	
	Boolean existsUserByEmail(String userEmail);
}
