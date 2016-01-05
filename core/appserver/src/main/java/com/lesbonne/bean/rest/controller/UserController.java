package com.lesbonne.bean.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lesbonne.business.bean.User;

/**
 * @author yucheng
 * @since 1
 * */
public interface UserController {
	
	public ResponseEntity<User> getUserByEmail(@PathVariable String userEmail);
	
	public ResponseEntity<User> getUserById(@PathVariable String userId);

	public ResponseEntity<String> updateUser(@RequestBody final User user);
	
	public ResponseEntity<User> addUser(@RequestBody User user); 

	public ResponseEntity<Boolean> removeUser(@RequestBody User user);
}
