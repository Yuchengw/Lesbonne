package com.lesbonne.promotion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lesbonne.promotionusage.PromotionUsage;

/**
 * @author Jassica
 * @since 1
 * */
@Repository("promotionCodeDAO")
public class PromotionCodeDAOImpl implements PromotionCodeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistPromotionCode(PromotionCode promotionCode) {
		sessionFactory.getCurrentSession().persist(promotionCode);
	}

	@Override
	public PromotionCode getPromotionCodeById(String promotionCodeId) {
		return (PromotionCode) sessionFactory.getCurrentSession().get(PromotionCode.class, promotionCodeId);
	}

	@Override
	public PromotionCode updatePromotionCode(PromotionCode promotionCode) {
		sessionFactory.getCurrentSession().update(promotionCode);
		return promotionCode;
	}
	
	@Override
	public void deletePromotionCode(PromotionCode promotionCode) {
		Session session = sessionFactory.getCurrentSession();
		PromotionCode toBeRemoved = (PromotionCode) session.get(PromotionCode.class, promotionCode.getPromotionCodeId());
        for (PromotionUsage usage : toBeRemoved.getPromotionUsages()) {
            usage.setPromotionCode(null);
        }
        session.delete(toBeRemoved);
	}
}
