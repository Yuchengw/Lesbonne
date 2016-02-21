package com.lesbonne.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lesbonne.utilities.TextUtil;
/**
 * @author yucheng
 * @since 1
 * */
@Controller
public class UserRestControllerImpl implements UserRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserRestControllerImpl.class);
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(method=RequestMethod.GET, value=UserRestURIConstants.EXISTS_USER_BY_EMAIL, produces = "application/json")
	public ResponseEntity<Boolean> existsUserByEmail(@PathVariable String userEmail) {
		Boolean exists = false;
		try {
			exists = userService.existsUserByEmail(userEmail);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(method=RequestMethod.GET, value=UserRestURIConstants.GET_USER_BY_EMAIL, produces = "application/json")
	public @ResponseBody ResponseEntity<User> getUserByEmail(@PathVariable String userEmail) {
		User user = null;
		try {
			user = userService.getUserByEmail(userEmail);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value=UserRestURIConstants.GET_USER_BY_ID, produces = "application/json")
	public @ResponseBody ResponseEntity<User> getUserById(@PathVariable String userId) {
		User user = null;
		try {
			user = userService.getUserById(userId);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(method=RequestMethod.PUT, value=UserRestURIConstants.UPDATE_USER, produces = "application/json")
	public @ResponseBody ResponseEntity<User> updateUser(@RequestBody User user) {
		User updatedUser = null;
		try {
			if (user == null || TextUtil.isNullOrEmpty(user.getUserEmail()) || TextUtil.isNullOrEmpty(user.getUserPassword()) 
					|| TextUtil.isNullOrEmpty(user.getUserId())) {
				return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			}
			updatedUser = userService.updateUser(user);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);	
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value=UserRestURIConstants.CREATE_USER, produces = "application/json")
	public @ResponseBody ResponseEntity<User> addUser(@RequestBody User user) {
		User result = null;
		try {
			if (user == null || TextUtil.isNullOrEmpty(user.getUserEmail()) || TextUtil.isNullOrEmpty(user.getUserPassword())) {
				return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
			}
			result = userService.persistUser(user);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(result, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=UserRestURIConstants.DELETE_USER, produces = "application/json")
	public @ResponseBody ResponseEntity<Boolean> deleteUser(@RequestBody User user) {
		try {
			userService.deleteUser(user);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
