package com.lesbonne.address;

public interface AddressService {
	
	Address persistAddress(Address address);
	
	void deleteAddress(Address address);
	
	Address getAddressById(String addressId);
	
	Address updateAddress(Address address);
}
