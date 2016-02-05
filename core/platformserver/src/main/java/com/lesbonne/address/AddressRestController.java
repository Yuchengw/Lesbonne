package com.lesbonne.address;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AddressRestController {
	ResponseEntity<Address> updateAddress(@RequestBody final Address address);
	
	ResponseEntity<Address> addAddress(@RequestBody Address address);
	
	ResponseEntity<Boolean> deleteAddress(@RequestBody Address address);
}
