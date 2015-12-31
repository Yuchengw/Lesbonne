package com.lesbonne.user;

import org.springframework.stereotype.Service;

/**
 * @author yucheng
 * @since 1
 * */
@Service
public interface UserService {
	
	void persistUser(User user);
	
	User getUserByEmail(String userEmail);
	
	User getUserById(String userId);
	
	User updateUser(User user);
	
	void deleteUser(User user);
}
