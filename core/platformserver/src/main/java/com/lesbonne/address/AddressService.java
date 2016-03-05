package com.lesbonne.address;

import java.util.List;

public interface AddressService {
	
	Address persistAddress(Address address) throws Exception;
	
	void deleteAddress(Address address);
	
	Address getAddressById(String addressId);
	
	Address updateAddress(Address address);
	
	Address[] searchNearbyLocations(double latitude, double longitude) throws Exception;
}
