package com.lesbonne.partner;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("PartnerDAO")
public class PartnerDAOImpl implements PartnerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistPartner(Partner partner) {
		sessionFactory.getCurrentSession().persist(partner);
	}

	@Override
	public Partner getPartnerById(String partnerId) {
		return (Partner) sessionFactory.getCurrentSession().get(Partner.class, partnerId);
	}

	@Override
	public Partner updatePartner(Partner partner) {
		sessionFactory.getCurrentSession().update(partner);
		return partner;
	}

	@Override
	public void deletePartner(Partner partner) {
		sessionFactory.getCurrentSession().delete(partner);
	}

}
