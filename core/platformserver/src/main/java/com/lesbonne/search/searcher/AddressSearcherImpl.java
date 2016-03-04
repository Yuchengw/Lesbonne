package com.lesbonne.search.searcher;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.search.SearchHit;

import com.google.common.collect.Lists;
import com.lesbonne.address.Address;

public class AddressSearcherImpl implements AddressSearcher {
	
	@Override
	public List<Address> searchNearbyLocations(double latitude, double longitude, int start, int end, int radius) throws Exception {
		SearchClient client = new SearchClientImpl();
		LocationSearchCriteria rule = new LocationSearchCriteria("address", start, end, radius);
		rule.addFieldQuery("location", new GeoPoint(latitude, longitude));
		
		SearchHit[] hits = client.searchLocation(rule);
		List<Address> results = Collections.emptyList();
		if (hits.length > 0) {
			results = Lists.newArrayListWithExpectedSize(hits.length);
		}
		
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
			results.add(address);
		}
		return results;
	}
}
