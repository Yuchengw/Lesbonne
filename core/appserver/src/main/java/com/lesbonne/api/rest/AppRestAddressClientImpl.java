package com.lesbonne.api.rest;

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
	
	public Address[] searchNearbyLocations(double latitude, double longitude) {
		return (Address[]) doGet(REST_ADDRESS_PREFIX + "/searchNearby/" + latitude + "/" + longitude);
	}
	
	public Address[] searchCityOrZipcode(String cityOrZipcode) {
		return (Address[]) doGet(REST_ADDRESS_PREFIX + "/searchCityOrZipcode/" + cityOrZipcode);
	}
	
	public String[] getAllZipcodes() {
		return (String[]) doGet(REST_ADDRESS_PREFIX + "/getAllZipcodes/");
	}
	
	public String[] getAllCities() {
		return (String[]) doGet(REST_ADDRESS_PREFIX + "/getAllCities/");
	}
}
