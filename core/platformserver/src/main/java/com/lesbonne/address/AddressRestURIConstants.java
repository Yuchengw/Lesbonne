package com.lesbonne.address;

/**
 * @author shuchun.yang
 * @since 1
 * */
public class AddressRestURIConstants {
	public static final String CREATE_ADDRESS = "/platform/v1/address/create";
	public static final String UPDATE_ADDRESS = "/platform/v1/address/update";
	public static final String DELETE_ADDRESS = "/platform/v1/address/delete";
	public static final String GET_ALL_ZIPCODES = "/platform/v1/address/getAllZipcodes";
	public static final String SEARCH_NEARBY_LOCATION = "/platform/v1/address/searchNearby/{latitude}/{longitude:.+}";
	public static final String SEARCH_ZIPCODE = "/platform/v1/address/searchZipcode/{zipcode}";
}
