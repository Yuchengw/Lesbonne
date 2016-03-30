package com.lesbonne.search.searcher;

import java.util.Map;

import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.search.SearchHit;

import com.lesbonne.address.Address;
import com.lesbonne.user.User;

public class AddressSearcherImpl implements AddressSearcher {
	
	public static final Address[] emptyAddress = new Address[0];
	
	@Override
	public Address[] searchCityOrZipcode(String cityOrZipcode, int start, int end) throws Exception {
		SearchClient client = new SearchClientImpl();
		SearchCriteria rule = new SearchCriteria("address", start, end);
		rule.addFieldQuery("zipcode", cityOrZipcode);
		rule.addFieldQuery("city", cityOrZipcode);
		SearchHit[] hits = client.searchCityOrZipcode(rule);
		
		return transformSearchResults(hits);
	}
	
	@Override
	public Address[] searchNearbyLocations(double latitude, double longitude, int start, int end, int radius) throws Exception {
		SearchClient client = new SearchClientImpl();
		LocationSearchCriteria rule = new LocationSearchCriteria("address", start, end, radius);
		rule.addFieldQuery("location", new GeoPoint(latitude, longitude));
		
		SearchHit[] hits = client.searchNearbyLocation(rule);
		
		return transformSearchResults(hits);
	}
	
	private Address[] transformSearchResults(SearchHit[] hits) {
		Address[] results = emptyAddress;
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
			User user = new User();
			user.setUserId((String)source.get("userId"));
			address.setUser(user);
			results[index] = address;
			index++;
		}
		
		return results;
	}
}
