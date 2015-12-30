package com.lesbonne.bean.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lesbonne.business.bean.User;

public interface UserController {
	
	public ResponseEntity<User> getUser(@PathVariable String userId);

	public ResponseEntity<String> updateUser(@RequestBody final User user);
	
	public ResponseEntity<String> addUser(@RequestBody User user); 

	public ResponseEntity<String> removeUser(@PathVariable String userId);
	
}
