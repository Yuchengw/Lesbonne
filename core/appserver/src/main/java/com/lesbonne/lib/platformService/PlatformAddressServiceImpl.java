package com.lesbonne.lib.platformService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lesbonne.business.bean.Address;
/**
 * @author shuchun.yang
 * @since 1
 * */
@Service
public class PlatformAddressServiceImpl extends PlatformAddressService implements PlatformAddressServiceConstants{
	
	private static final Logger logger = LoggerFactory.getLogger(PlatformAddressServiceImpl.class);	
	
	/**
	 * This function is used for create address
	 * @throws Exception 
	 * */
	public Address createAddress(Address address) {
		Address newAddress = null;
		try {
			newAddress = getAddressRestClient().createAddress(address);
		} catch (Exception e) {
			throw new RuntimeException("there is something wrong when inserting address object" + e.getMessage());
		}
		return newAddress;
	}
	
	/**
	 * This function is used for update user in mongodb
	 * @throws Exception 
	 * */
	public Address updateAddress(Address address) {
		Address updateAddress = null;
		try {
			updateAddress = getAddressRestClient().updateAddress(address);
		} catch (Exception e) {
			throw new RuntimeException("there is something wrong when updating address object" + e.getMessage());
		}
		return updateAddress;
	}
	
	/**
	 * 
	 * */
	public boolean deleteAddress(Address address) {
		boolean success = false;
		try {
			success = getAddressRestClient().deleteAddress(address);
		} catch (Exception e) {
			throw new RuntimeException("Exception thrown when delete address" + e.getMessage());
		} 
		return success;
	}
	
	public List<Address> searchNearbyLocations(double latitude, double longitude) {
		List<Address> addresses = null;
		try {
			addresses = getAddressRestClient().searchNearbyLocations(latitude, longitude);
		} catch (Exception e) {
			throw new RuntimeException("there is something wrong when search nearby locations " + e.getMessage());
		}
		return addresses;
	}
}
