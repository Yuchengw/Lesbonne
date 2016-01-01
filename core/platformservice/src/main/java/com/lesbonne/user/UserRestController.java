package com.lesbonne.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserRestController {
		
	public User getUser(@PathVariable User user);
	
	public ResponseEntity<String> updateUser(@RequestBody final User user);
	
	public ResponseEntity<String> addUser(@RequestBody User user);
	
	public ResponseEntity<String> deleteUser(@PathVariable User user);
}
