package com.lesbonne.api.rest;

import java.util.List;

import com.lesbonne.business.bean.Address;

/**
 * @author shuchun.yang
 * @since 1
 * */
public class AppRestAddressClientImpl extends RestClient<Address, Object> {

	private static final String REST_ADDRESS_PREFIX = "address";
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AppRestAddressClientImpl(Class expectedType) {
		super(expectedType);
	}
	
	public Address createAddress(Address a) {
		return (Address) doPost(REST_ADDRESS_PREFIX + "/create", a);
	}
		
	public Address updateAddress(Address a) {
		return (Address) doPost(REST_ADDRESS_PREFIX + "/update", a);
	}
	
	public boolean deleteAddress(Address deleteAddress) {
		return (boolean) doPost(REST_ADDRESS_PREFIX + "/delete/", deleteAddress);
	}
	
	@SuppressWarnings("unchecked")
	public List<Address> searchNearbyLocations(double latitude, double longitude) {
		return (List<Address>) doGet(REST_ADDRESS_PREFIX + "/search/" + latitude + "/" + longitude);
	}
}
