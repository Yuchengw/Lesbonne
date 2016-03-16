package com.lesbonne.address;

import org.hibernate.SessionFactory;
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

}
