package com.lesbonne.geocoding;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class GoogleGeocodingServiceImpl implements GoogleGeocodingService {
	
	@Override
	public LatLng getGeocodingData(String address) throws Exception {
		GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
		GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
		GeocodingResult result = results[0];
		return result.geometry.location;
	}
}
