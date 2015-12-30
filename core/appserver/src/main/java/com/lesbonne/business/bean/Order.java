package com.lesbonne.business.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yucheng
 * @version 1
 * */
public class Order extends BeanObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8295725653761130449L;
	private String orderId;
	private User owner;

	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
}
