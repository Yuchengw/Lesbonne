package com.lesbonne.user;

import org.springframework.stereotype.Service;

/**
 * @author yucheng
 * @since 1
 * */
public interface UserService {
	
	void persistUser(User user) throws Exception;
	
	User getUserByEmail(String userEmail);
	
	User getUserById(String userId);
	
	User updateUser(User user) throws Exception;
	
	void deleteUser(User user);
	
	Boolean existsUserByEmail(String userEmail);
}
