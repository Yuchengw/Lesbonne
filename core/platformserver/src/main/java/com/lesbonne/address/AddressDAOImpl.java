package com.lesbonne.address;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("AddressDAO")
public class AddressDAOImpl implements AddressDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Address persistAddress(Address address) {
		sessionFactory.getCurrentSession().persist(address);
		return address;
	}

	@Override
	public void deleteAddress(Address address) {
		sessionFactory.getCurrentSession().delete(address);
	}

	@Override
	public Address getAddressById(String addressId) {
		return (Address) sessionFactory.getCurrentSession().get(Address.class, addressId);
	}

	@Override
	public Address updateAddress(Address address) {
		sessionFactory.getCurrentSession().update(address);
		return address;
	}
	
	@Override
	public String[] getAllZipcodes() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Address.class);
		criteria.setProjection(Projections.distinct(Projections.property("zipcode")));
		List<String> zipcodes =  (List<String>)criteria.list();
		String[] zipcodesArray = new String[zipcodes.size()];
		zipcodes.toArray(zipcodesArray);
		return zipcodesArray;
	}

}
