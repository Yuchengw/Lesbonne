package com.lesbonne.user;

/**
 * @author yucheng
 * @since 1
 * */
public interface UserDAO {
	
	User persistUser(User user);

	void deleteUser(User user);

	User getUserByEmail(String email);
	
	User getUserById(String id);
	
	User updateUser(User user);
	
	Boolean existsUserByEmail(String email);
}
