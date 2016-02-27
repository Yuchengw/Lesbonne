package com.lesbonne.geocoding;

import com.google.maps.model.LatLng;

public interface GoogleGeocodingService {
	
	final String API_KEY = "AIzaSyCdNnSfmaudQXVTO3Q3_VfTcl70r75wca8";
	
	LatLng getGeocodingData(String address) throws Exception;
}
