package com.lesbonne.geocoding;

import com.google.maps.model.LatLng;

public interface GoogleGeocodingService {
	
	LatLng getGeocodingData(String address) throws Exception;
}
