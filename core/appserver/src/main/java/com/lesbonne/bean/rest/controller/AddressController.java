package com.lesbonne.bean.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lesbonne.business.bean.Address;

/**
 * @author shuchun.yang
 * @since 1
 * */
public interface AddressController {
	ResponseEntity<Address> updateAddress(@RequestBody final Address address);
	
	ResponseEntity<Address> addAddress(@RequestBody Address address) throws Exception; 

	ResponseEntity<Boolean> removeAddress(@RequestBody Address address);
	
	ResponseEntity<Address[]> searchNearbyLocations(@PathVariable double latitude, @PathVariable double longitude);
	
	ResponseEntity<Address[]> searchZipcode(@PathVariable String zipcode);
	
	ResponseEntity<String[]> getAllZipcodes();
		
}
