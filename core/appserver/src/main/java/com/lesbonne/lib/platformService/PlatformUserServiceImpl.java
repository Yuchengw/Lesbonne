package com.lesbonne.lib.platformService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lesbonne.api.rest.AppRestUserClientImpl;
import com.lesbonne.api.rest.RestClient;
import com.lesbonne.business.bean.User;
import com.lesbonne.system.security.EncryptionUtil;
import com.lesbonne.util.monitoring.UserControllerPerformanceMonitorInterceptor;

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
			if (user == null) {
			
			}
		} catch (Exception e) {
			logger.debug("Error happens when retriving User object" + e.getStackTrace());
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
//			user.setUserPassword(EncryptionUtil.encryptPassword(user.getPassword()));
			newUser = getUserRestClient().createUser(user);
			if (newUser == null) {
				
			}
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
		User user = null;
		try {
			user = getUserRestClient().deleteUser(u);
		} catch (Exception e) {
			throw new RuntimeException("Exception thrown when delete user" + e.getMessage());
		} 
		return user != null;
	}
	
	/**
	 * TODO:
	 * */
	public boolean deleteUser(String userId) {
		return  true;
	}
	
	public boolean existsUserByEmail(String userEmail) {
		boolean exists = false;
		try {
			exists = getUserRestClient().existsUserByEmail(userEmail);
		} catch (Exception e) {
			logger.debug("there is somethign wrong when checking user exists with user email.");
		} finally {
			
		}
		return exists;
	}
	
	/**
	 * TODO:
	 * */
	public boolean existsUserById(String userId) {
		return true;
	}
}
