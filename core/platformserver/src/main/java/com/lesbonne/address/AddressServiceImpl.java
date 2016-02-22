package com.lesbonne.address;

import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDAO addressDAO;
	
	@Override
	public Address persistAddress(Address address) {
		return addressDAO.persistAddress(address);
	}

	@Override
	public void deleteAddress(Address address) {
		addressDAO.deleteAddress(address);
	}

	@Override
	public Address getAddressById(String addressId) {
		return addressDAO.getAddressById(addressId);
	}

	@Override
	public Address updateAddress(Address address) {
		return addressDAO.updateAddress(address);
	}

}
