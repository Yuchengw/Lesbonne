package com.lesbonne.bean.rest.controller;

/**
 * @author shuchun.yang
 * @since 1
 * */
public class AddressRestURIConstants {
	 public static final String CREATE_ADDRESS = "/service/address/create";
	 public static final String UPDATE_ADDRESS = "/service/address/update";
	 public static final String DELETE_ADDRESS = "/service/address/delete";
	 public static final String SEARCH_NEARBY_LOCATION = "/service/address/searchNearby/{latitude}/{longitude:.+}";
	 public static final String SEARCH_ZIPCODE = "/service/address/searchZipcode/{zipcode}";
	 public static final String GET_ALL_ZIPCODES = "/service/address/getAllZipcodes";
}
