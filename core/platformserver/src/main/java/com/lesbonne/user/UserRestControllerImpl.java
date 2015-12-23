package com.lesbonne.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.json.JSONMarshaller;

/**
 * @author yucheng
 * @since 1
 * */
@Controller
public class UserRestControllerImpl implements UserRestController {

	private static final Logger logger = LoggerFactory.getLogger(UserRestControllerImpl.class);
	@Autowired
	private UserService userServiceImpl;
	
	@Override
	@RequestMapping(method=RequestMethod.GET, value=UserRestURIConstants.GET_USER)
	public User getUser(@PathVariable User user) {
		if (user == null) {
			throw new RuntimeException("User Not Found.");
		}
		try {
			user = userServiceImpl.getUserByEmail(user.getUserEmail());
		} catch (Exception e) {
			return null;
		}	
		return user;
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, value=UserRestURIConstants.UPDATE_USER)
	public ResponseEntity<String> updateUser(@RequestBody final User user) {
		try {
			userServiceImpl.updateUser(user);
		} catch (Exception e) {
			return new ResponseEntity<String>("user update failed.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("user upadate success.", HttpStatus.OK);	
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value=UserRestURIConstants.CREATE_USER, produces = "application/json")
	public ResponseEntity<String> addUser(User user) {
		try {
			userServiceImpl.persistUser(user);
		} catch (Exception e) {
			return new ResponseEntity<String>("user creation failed." + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("user creation success.", HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=UserRestURIConstants.DELETE_USER)
	public ResponseEntity<String> deleteUser(User user) {
		try {
			userServiceImpl.deleteUser(user);
		} catch (Exception e) {
			return new ResponseEntity<String>("user deletion failed." + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("user deletion failed.", HttpStatus.OK);
	}
	

}
