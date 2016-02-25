package com.lesbonne.address;

import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lesbonne.search.indexer.AddressIndexer;

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
		
		System.out.println("CREATE");
		System.out.println(response);
		
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

}
