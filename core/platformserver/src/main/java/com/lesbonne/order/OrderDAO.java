package com.lesbonne.order;

/**
 * @author yucheng
 * @since 1
 * */
public interface OrderDAO {

	void persistOrder(Order order);
	
	void deleteOrder(Order order);
	
	Order getOrderById(String orderId);
	
	Order updateOrder(Order order);
}
