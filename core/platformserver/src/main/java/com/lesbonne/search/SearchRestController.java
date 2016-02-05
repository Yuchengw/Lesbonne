package com.lesbonne.search;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.lesbonne.address.Address;

public interface SearchRestController {
	
	public ResponseEntity<List<Address>> getUserByEmail(@PathVariable float latitude, @PathVariable float longitude);
}
