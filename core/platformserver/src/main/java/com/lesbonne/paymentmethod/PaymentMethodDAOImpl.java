package com.lesbonne.paymentmethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lesbonne.order.Order;
import com.lesbonne.postcomment.PostComment;
import com.lesbonne.sharingpost.SharingPost;

/**
 * @author Jassica
 * @since 1
 * */
@Repository("PaymentMethodDAO")
public class PaymentMethodDAOImpl implements PaymentMethodDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistPaymentMethod(PaymentMethod paymentMethod) {
		sessionFactory.getCurrentSession().persist(paymentMethod);
	}
	
	@Override
	public PaymentMethod getPaymentMethodById(String paymentMethodId) {
		return (PaymentMethod) sessionFactory.getCurrentSession().get(PaymentMethod.class, paymentMethodId);
	}

	@Override
	public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
		sessionFactory.getCurrentSession().update(paymentMethod);
		return paymentMethod;
	}
	
	@Override
	public void deletePaymentMethod(PaymentMethod paymentMethod) {
		Session session = sessionFactory.getCurrentSession();
        PaymentMethod toBeRemoved = (PaymentMethod) session.get(PaymentMethod.class, paymentMethod.getPaymentMethodId());
//        for (PostComment comment : toBeRemoved.getPostComments()) {
//            comment.setPaymentMethod(null);
//        }
//        for (Order order : toBeRemoved.getOrders()) {
//            order.setPaymentMethod(null);
//        }
        session.delete(toBeRemoved);
	}
}
