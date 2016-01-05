package com.lesbonne.lib.platformService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lesbonne.business.bean.User;
import com.lesbonne.system.security.EncryptionUtil;

/**
 * @author yucheng
 * @since 1
 * */
@Service
public class PlatformUserServiceImpl extends PlatformUserService implements PlatformUserServiceConstants{
	
	private static final Logger logger = LoggerFactory.getLogger(PlatformUserServiceImpl.class);	
	
	/**
	 * this function is used for get user info from platform without password authentication,
	 * use this with carefulness.
	 * @param userEmail
	 * @return User 
	 * */
	public User getUserByEmail(String userEmail) {
		User user = null;
		try {
			user = getUserRestClient().getUserByEmail(userEmail);
		} catch (Exception e) {
			logger.debug("Error happens when retriving User object by userEmail" + e);
		}
		return user;
	}
	
	/**
	 * 
	 * */
	public User getUserById(String userId) {
		User user = null;
		try {
			user = getUserRestClient().getUserById(userId);
		} catch (Exception e) {
			logger.debug("Error happends when retriving User Object by userId" + e);
		}
		return user;
	}
	
	/**
	 * 
	 * */
	public User getUserByEmailAndPassword(String userEmail, String password) {
		User user = null;
		try {
			user = getUserRestClient().getUserByEmail(userEmail);
			if (user != null && EncryptionUtil.encryptPassword(user.getPassword()).equals(EncryptionUtil.encryptPassword(password))) {
				return user;
			} else {
				
			}
		} catch (Exception e) {
			logger.debug("Error happens when retriving User object" + e.getStackTrace());
		}
		return user;
	}
	
	/**
	 * This function is used for create user in mongodb
	 * @throws Exception 
	 * */
	public User createUser(User user) {
		User newUser = null;
		try {
			newUser = getUserRestClient().createUser(user);
		} catch (Exception e) {
			logger.debug("there is something wrong when inserting user object" + e.getStackTrace());
		}
		return newUser;
	}
	
	/**
	 * This function is used for update user in mongodb
	 * @throws Exception 
	 * */
	public User updateUser(User user) {
		User updateUser = null;
		try {
			updateUser = getUserRestClient().updateUser(user);
		} catch (Exception e) {
			logger.debug("there is something wrong when inserting user object" + e.getStackTrace());
		}
		return updateUser;
	}
	
	/**
	 * 
	 * */
	public boolean deleteUser(User u) {
		boolean success = false;
		try {
			success = getUserRestClient().deleteUser(u);
		} catch (Exception e) {
			throw new RuntimeException("Exception thrown when delete user" + e.getMessage());
		} 
		return success;
	}
	
	public boolean existsUserByEmail(String userEmail) {
		boolean exists = false;
		try {
			exists = getUserRestClient().existsUserByEmail(userEmail);
		} catch (Exception e) {
			logger.debug("there is something wrong when checking user exists with user email." + e);
		} 
		return exists;
	}
	
	/**
	 * 
	 * */
	public boolean existsUserById(String userId) {
		boolean exists = false;
		try {
			exists = getUserRestClient().existsUserByid(userId);
		} catch (Exception e) {
			logger.debug("there is something wrong when checking user exists with user id." + e);
		}
		return exists;
	}
}
