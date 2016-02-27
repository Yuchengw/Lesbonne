package com.lesbonne.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yucheng
 * @since 1
 * */
@Service("OrderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	@Transactional
	public Order persistOrder(Order order) {
		orderDAO.persistOrder(order);
		return order;
	}
	
	@Override
	@Transactional
	public Order getOrderById(String orderId) {
		return orderDAO.getOrderById(orderId);
	}
	
	@Override
	@Transactional
	public Order updateOrder(Order order) {
		return orderDAO.updateOrder(order);
	}
	
	@Override
	@Transactional
	public void deleteOrder(Order order) {
		orderDAO.deleteOrder(order);
	}
}
