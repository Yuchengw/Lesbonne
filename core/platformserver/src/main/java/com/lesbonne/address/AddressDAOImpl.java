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
	
	private String[] getAddressInfo(String columnName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Address.class);
		criteria.setProjection(Projections.distinct(Projections.property(columnName)));
		List<String> addressInfo =  (List<String>)criteria.list();
		String[] addressInfoArray = new String[addressInfo.size()];
		addressInfo.toArray(addressInfoArray);
		return addressInfoArray;
	}
	
	@Override
	public String[] getAllZipcodes() {
		return getAddressInfo("zipcode");
	}
	
	@Override
	public String[] getAllCities() {
		return getAddressInfo("city");
	}

}
