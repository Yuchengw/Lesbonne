package com.lesbonne.bean.rest.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.model.LatLng;
import com.lesbonne.business.bean.Address;
import com.lesbonne.geocoding.GoogleGeocodingService;
import com.lesbonne.geocoding.GoogleGeocodingServiceImpl;
import com.lesbonne.lib.objectProvider.AddressProvider;

/**
 * This class is used for Restful API Address Control.
 * 
 * @author shuchun.yang
 * @since 1
 * */
@RestController
public class AddressControllerImpl implements AddressController {
	
	@Autowired
	private AddressProvider addressProvider;
	
	@RequestMapping(method=RequestMethod.PUT, value=AddressRestURIConstants.UPDATE_ADDRESS)
	public ResponseEntity<Address> updateAddress(@RequestBody Address address) {	
		addressProvider.update(address);
		return new ResponseEntity<Address>(address, HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.POST, value=AddressRestURIConstants.CREATE_ADDRESS)
	public ResponseEntity<Address> addAddress(@RequestBody Address address) throws Exception {
		//TODO - add validation
		GoogleGeocodingService geocodingService = new GoogleGeocodingServiceImpl();
		LatLng latlng  =geocodingService.getGeocodingData(address.toString());
		address.setLatitude(latlng.lat);
		address.setLongitude(latlng.lng);
		Address newAddress = addressProvider.add(address);
		if (newAddress != null) {
			return new ResponseEntity<Address>(newAddress, HttpStatus.OK);
		} 
		return new ResponseEntity<Address>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method=RequestMethod.POST, value=AddressRestURIConstants.DELETE_ADDRESS)
	public ResponseEntity<Boolean> removeAddress(@RequestBody Address address) {
		if (addressProvider.remove(address)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(false, HttpStatus.FORBIDDEN);
		}
	}
}