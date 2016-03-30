package com.lesbonne.search.searcher;

import com.lesbonne.address.Address;

public interface AddressSearcher {
	
	Address[] searchCityOrZipcode(String cityOrZipcode, int start, int end) throws Exception;
	
	Address[] searchNearbyLocations(double latitude, double longitude, int start, int end, int radius) throws Exception;
}
