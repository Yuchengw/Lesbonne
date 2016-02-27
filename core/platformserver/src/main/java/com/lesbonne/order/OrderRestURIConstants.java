package com.lesbonne.order;

/**
 * The URI constants for the order rest service
 * @author jassica
 * @version 1
 */
public class OrderRestURIConstants {
	public static final String GET_ORDER_BY_ID = "/platform/v1/order/getOrderById/{orderId}";
	public static final String CREATE_ORDER = "/platform/v1/order/create";
	public static final String UPDATE_ORDER = "/platform/v1/order/update";
	public static final String DELETE_ORDER = "/platform/v1/order/delete";
}
