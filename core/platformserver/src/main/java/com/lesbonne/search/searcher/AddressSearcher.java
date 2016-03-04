package com.lesbonne.search.searcher;

import java.util.List;

import com.lesbonne.address.Address;

public interface AddressSearcher {
	
	List<Address> searchNearbyLocations(double latitude, double longitude, int start, int end, int radius) throws Exception;
}
