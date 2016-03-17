package com.lesbonne.address;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AddressRestController {
	ResponseEntity<Address> updateAddress(@RequestBody final Address address);
	
	ResponseEntity<Address> addAddress(@RequestBody Address address);
	
	ResponseEntity<Boolean> deleteAddress(@RequestBody Address address);
	
	ResponseEntity<Address[]> searchNearbyLocations(@PathVariable double latitude, @PathVariable double longitude);
	
	ResponseEntity<Address[]> searchZipcode(@PathVariable String zipcode);
	
	ResponseEntity<String[]> getAllZipcodes();
}
