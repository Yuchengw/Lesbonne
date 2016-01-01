package com.lesbonne.user;

/**
 * @author yucheng
 * @since 1
 * */
public interface UserDAO {
	
	void persistUser(User user);

	void deleteUser(User user);

	User getUserByEmail(String userEmail);
	
	User getUserById(String userId);
	
	User updateUser(User user);
}
