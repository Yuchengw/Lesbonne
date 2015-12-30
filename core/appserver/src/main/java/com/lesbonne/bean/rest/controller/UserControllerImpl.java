package com.lesbonne.bean.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lesbonne.business.bean.User;
import com.lesbonne.lib.objectProvider.UserProvider;
import com.lesbonne.web.security.UserAuthentication;

/**
 * This class is used for Restful API User Control.
 * 
 * @author yucheng
 * @since 1
 * */
@RestController
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserProvider userProvider;

	/**
	 * Get current user, return usercontext via Spring security context
	 * @return User Bean
	 * */
	@RequestMapping(method=RequestMethod.GET, value=UserRestURIConstants.GET_USER)
	public ResponseEntity<User> getUser(@PathVariable String userEmail) {
		User user = null;
		try {
			final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication instanceof UserAuthentication) {
				user = ((UserAuthentication) authentication).getDetails();
			} else {
				user = userProvider.get(userEmail);
			} 
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value=UserRestURIConstants.UPDATE_USER)
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final User currentUser = userProvider.get(authentication.getName());
		
		final BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		if (!pwEncoder.matches(user.getPassword(), currentUser.getPassword())) {
			return new ResponseEntity<String>("old password mismatch", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		userProvider.update(user);
		return new ResponseEntity<String>("user upadate success", HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.POST, value=UserRestURIConstants.CREATE_USER)
	public ResponseEntity<String> addUser(@RequestBody User user) {
		if (user.getUserEmail() == null) {
			return new ResponseEntity<String>("Email not eligible", HttpStatus.UNPROCESSABLE_ENTITY);
		}  
		
		if (userProvider.existsByEmail(user.getUserEmail())) {
			return new ResponseEntity<String>("User already exists", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		if (user.getPassword() == null || user.getPassword().length() <= 6) {
			return new ResponseEntity<String>("new password too short", HttpStatus.UNPROCESSABLE_ENTITY);
		} 
		
//		final BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
//		user.setUserPassword(pwEncoder.encode(user.getPassword()));
		user.setAccountEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setIsEmailAuthorized(true);
		userProvider.add(user);
		return new ResponseEntity<String>("User creation success", HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=UserRestURIConstants.DELETE_USER)
	public ResponseEntity<String> removeUser(@PathVariable String userId) {
		userProvider.remove(userId);
		return new ResponseEntity<String>("User Deleted successful", HttpStatus.OK);
	}

}
