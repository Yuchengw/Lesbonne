package com.lesbonne.address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author shuchun.yang
 * @since 1
 * */
@Controller
public class AddressRestControllerImpl implements AddressRestController {

	private static final Logger logger = LoggerFactory.getLogger(AddressRestControllerImpl.class);
	
	@Autowired
	private AddressService addressService;
	
	@Override
	@RequestMapping(method=RequestMethod.PUT, value=AddressRestURIConstants.UPDATE_ADDRESS, produces = "application/json")
	public @ResponseBody ResponseEntity<Address> updateAddress(@RequestBody Address address) {
		Address updatedAddress = null;
		try {
			updatedAddress = addressService.updateAddress(address);
		} catch (Exception e) {
			return new ResponseEntity<Address>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Address>(updatedAddress, HttpStatus.OK);	
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value=AddressRestURIConstants.CREATE_ADDRESS, produces = "application/json")
	public @ResponseBody ResponseEntity<Address> addAddress(@RequestBody Address address) {
		Address result = null;
		try {
			result = addressService.persistAddress(address);
		} catch (Exception e) {
			return new ResponseEntity<Address>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Address>(result, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=AddressRestURIConstants.DELETE_ADDRESS, produces = "application/json")
	public @ResponseBody ResponseEntity<Boolean> deleteAddress(@RequestBody Address address) {
		try {
			addressService.deleteAddress(address);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(method=RequestMethod.GET, value=AddressRestURIConstants.SEARCH_NEARBY_LOCATION, produces = "application/json")
	public @ResponseBody ResponseEntity<Address[]> searchNearbyLocations(@PathVariable double latitude, @PathVariable double longitude) {
		Address[] nearbyLocations = null;
		try {
			nearbyLocations = addressService.searchNearbyLocations(latitude, longitude);
		} catch (Exception e) {
			return new ResponseEntity<Address[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Address[]>(nearbyLocations, HttpStatus.OK);
	}
}
