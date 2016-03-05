package com.lesbonne.search.searcher;

import java.util.Map;

import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.search.SearchHit;


import com.lesbonne.address.Address;

public class AddressSearcherImpl implements AddressSearcher {
	
	@Override
	public Address[] searchNearbyLocations(double latitude, double longitude, int start, int end, int radius) throws Exception {
		SearchClient client = new SearchClientImpl();
		LocationSearchCriteria rule = new LocationSearchCriteria("address", start, end, radius);
		rule.addFieldQuery("location", new GeoPoint(latitude, longitude));
		
		SearchHit[] hits = client.searchLocation(rule);
		Address[] results = null;
		if (hits.length > 0) {
			results = new Address[hits.length];
		}
		
		int index = 0;
		for (SearchHit hit : hits) {
			Address address = new Address();
			Map<String, Object> source = hit.getSource();
			address.setAddressId(hit.getId());
			address.setName((String)source.get("name"));
			address.setStreet1((String)source.get("street1"));
			address.setStreet2((String)source.get("street2"));
			address.setZipcode((String)source.get("zipcode"));
			address.setCity((String)source.get("city"));
			address.setState((String)source.get("state"));
			address.setCountry((String)source.get("country"));
			Map<String, Double> location = (Map<String, Double>)source.get("location");
			address.setLongitude(String.valueOf(location.get("lon")));
			address.setLatitude(String.valueOf(location.get("lat")));
			results[index] = address;
			index++;
		}
		return results;
	}
}
