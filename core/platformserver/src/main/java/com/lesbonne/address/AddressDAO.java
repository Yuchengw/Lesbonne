package com.lesbonne.address;

import com.lesbonne.address.Address;

/**
 * 
 * @author shuchun.yang
 *
 */
public interface AddressDAO {
	
	Address persistAddress(Address address);
	
	void deleteAddress(Address Address);
	
	Address getAddressById(String addressId);
	
	Address updateAddress(Address address);
	
	String[] getAllZipcodes();
	
	String[] getAllCities();
}
