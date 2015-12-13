package com.lesbonne.order;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author yucheng
 * @since 1
 * */
@Repository("OrderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistOrder(Order order) {
		sessionFactory.getCurrentSession().persist(order);
	}
	
	@Override
	public Order getOrderById(String orderId) {
		return (Order) sessionFactory.getCurrentSession().get(Order.class, orderId);
	}

	@Override
	public Order updateOrder(Order order) {
		sessionFactory.getCurrentSession().update(order);
		return order;
	}

	@Override
	public void deleteOrder(Order order) {
		sessionFactory.getCurrentSession().delete(order);
	}
}
