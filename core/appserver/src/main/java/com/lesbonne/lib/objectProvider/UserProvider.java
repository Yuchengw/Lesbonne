package com.lesbonne.lib.objectProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesbonne.business.bean.User;
import com.lesbonne.lib.platformService.PlatformUserService;
import com.lesbonne.lib.platformService.PlatformUserServiceImpl;

/**
 * @author yucheng
 * @since 1
 * */
@Service
public class UserProvider {

	@Autowired
	private PlatformUserServiceImpl platformUserServiceImpl;
	
	public PlatformUserServiceImpl getUserServiceImpl() {
		return (PlatformUserServiceImpl) this.platformUserServiceImpl;
	}
	
	public User add(User user) {
		return this.platformUserServiceImpl.createUser(user);
	}
	
	public User getUserByEmail(String email) {
		return new PlatformUserServiceImpl().getUserByEmail(email);
	}
	
	public User getUserById(String id) {
		return new PlatformUserServiceImpl().getUserById(id);
	}

	public boolean remove(User  user) {
		try {
			return new PlatformUserServiceImpl().deleteUser(user);
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * update is expensive, think before do it
	 * */
	public void update(User updateUser) {
		this.platformUserServiceImpl.updateUser(updateUser);
	}

	/**
	 * find user by user's name, used for spring security
	 * @param userEmail
	 * @param userPassword
	 * @return User
	 * */
	public User findByUserNameAndPassword(String userEmail, String password) {
		return this.platformUserServiceImpl.getUserByEmailAndPassword(userEmail, password);
	}
	
	/**
	 * Check if this email has already been registered
	 * @param email
	 * @return true or false
	 * */
	public boolean existsByEmail(String email) {
		try {
			return this.platformUserServiceImpl.existsUserByEmail(email);
		} catch (Exception e) {
			return false;
		}
	}
}
