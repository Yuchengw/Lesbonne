package com.lesbonne.order;

/**
 * @author yucheng
 * @since 1
 * */
public interface OrderService {
	
	Order persistOrder(Order order);
	
	Order getOrderById(String orderId);
	
	Order updateOrder(Order order);
	
	void deleteOrder(Order order);
}
