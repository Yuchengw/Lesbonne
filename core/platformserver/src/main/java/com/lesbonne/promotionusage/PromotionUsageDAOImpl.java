package com.lesbonne.promotionusage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Jassica
 * @since 1
 * */
@Repository("promotionUsageDAO")
public class PromotionUsageDAOImpl implements PromotionUsageDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistPromotionUsage(PromotionUsage promotionUsage) {
		sessionFactory.getCurrentSession().persist(promotionUsage);
	}

	@Override
	public PromotionUsage getPromotionUsageById(String promotionUsageId) {
		return (PromotionUsage) sessionFactory.getCurrentSession().get(PromotionUsage.class, promotionUsageId);
	}

	@Override
	public PromotionUsage updatePromotionUsage(PromotionUsage promotionUsage) {
		sessionFactory.getCurrentSession().update(promotionUsage);
		return promotionUsage;
	}
	
	@Override
	public void deletePromotionUsage(PromotionUsage promotionUsage) {
		Session session = sessionFactory.getCurrentSession();
		PromotionUsage toBeRemoved = (PromotionUsage) session.get(PromotionUsage.class, promotionUsage.getPromotionUsageId());
        session.delete(toBeRemoved);
	}
}
