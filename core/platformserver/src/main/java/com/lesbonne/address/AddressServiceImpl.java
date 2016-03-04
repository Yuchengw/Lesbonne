package com.lesbonne.address;

import java.util.List;

import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lesbonne.search.ElasticSearchConstants;
import com.lesbonne.search.indexer.AddressIndexer;
import com.lesbonne.search.searcher.AddressSearcher;
import com.lesbonne.search.searcher.AddressSearcherImpl;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDAO addressDAO;
	
	@Override
	@Transactional
	public Address persistAddress(Address address) throws Exception {
		addressDAO.persistAddress(address);
		AddressIndexer indexer = new AddressIndexer("address", address);
		IndexResponse response = indexer.create();
		
		return address;
	}

	@Override
	@Transactional
	public void deleteAddress(Address address) {
		addressDAO.deleteAddress(address);
	}

	@Override
	public Address getAddressById(String addressId) {
		return addressDAO.getAddressById(addressId);
	}

	@Override
	@Transactional
	public Address updateAddress(Address address) {
		return addressDAO.updateAddress(address);
	}
	
	@Override
	public List<Address> searchNearbyLocations(double latitude, double longitude) throws Exception {
		AddressSearcher searcher = new AddressSearcherImpl();
		return searcher.searchNearbyLocations(latitude, longitude, ElasticSearchConstants.START, ElasticSearchConstants.END, ElasticSearchConstants.RADIUS);
	}

}
