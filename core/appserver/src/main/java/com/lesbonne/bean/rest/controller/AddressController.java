package com.lesbonne.bean.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.lesbonne.business.bean.Address;

/**
 * @author yucheng
 * @since 1
 * */
public interface AddressController {
	public ResponseEntity<String> updateAddress(@RequestBody final Address address);
	
	public ResponseEntity<Address> addAddress(@RequestBody Address address) throws Exception; 

	public ResponseEntity<Boolean> removeAddress(@RequestBody Address address);
}
