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

/**
 * @author yucheng
 * @since 1
 * */
@Controller
public class UserRestControllerImpl implements UserRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserRestControllerImpl.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value=UserRestURIConstants.EXISTS_USER_BY_EMAIL)
	public ResponseEntity<Boolean> existsUserByEmail(@PathVariable String userEmail) {
		Boolean exists = false;
		try {
			exists = userService.existsUserByEmail(userEmail);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value=UserRestURIConstants.GET_USER)
	public ResponseEntity<User> getUser(@PathVariable String userEmail) {
		User user = null;
		try {
			user = userService.getUserByEmail(userEmail);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, value=UserRestURIConstants.UPDATE_USER)
	public ResponseEntity<User> updateUser(User user) {
		User updatedUser = null;
		try {
			updatedUser = userService.updateUser(user);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);	
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value=UserRestURIConstants.CREATE_USER, produces = "application/json")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		try {
			userService.persistUser(user);
		} catch (Exception e) {
			return new ResponseEntity<String>("user creation failed.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("user creation success.", HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=UserRestURIConstants.DELETE_USER)
	public ResponseEntity<String> deleteUser(User user) {
		try {
			userService.deleteUser(user);
		} catch (Exception e) {
			return new ResponseEntity<String>("user deletion failed." + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("user deletion failed.", HttpStatus.OK);
	}
	

}
