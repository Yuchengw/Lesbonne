package com.lesbonne.user;


/**
 * @author yucheng
 * @since 1
 * */
public interface UserDAO {
	
	void persistUser(User user);

	void deleteUser(User user);

	User getUserByEmail(String email);
	
	User updateUser(User user);
}
