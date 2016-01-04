package com.lesbonne.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserRestController {
		
	public ResponseEntity<User> getUserByEmail(@PathVariable String email);
	
	public ResponseEntity<User> updateUser(@RequestBody final User user);
	
	public ResponseEntity<User> addUser(@RequestBody User user);
	
	public ResponseEntity<Boolean> deleteUser(@PathVariable User user);
}
