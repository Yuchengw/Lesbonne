package com.lesbonne.user;

/**
 * @author yucheng
 * @since 1
 * */
public interface UserService {
	
	void persistUser(User user);
	
	User getUserByEmail(String userEmail);
	
	User updateUser(User user);
	
	void deleteUser(User user);
}
