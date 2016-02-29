package com.lesbonne.paymentmethod;

/**
 * The URI constants for the PaymentMethod rest service
 * @author jassica
 * @version 1
 */
public class PaymentMethodRestURIConstants {
	public static final String GET_PAYMENTMETHOD_BY_ID = "/platform/v1/paymentmethod/getPaymentMethodById/{paymentMethodId}";
	public static final String CREATE_PAYMENTMETHOD = "/platform/v1/paymentmethod/create";
	public static final String UPDATE_PAYMENTMETHOD = "/platform/v1/paymentmethod/update";
	public static final String DELETE_PAYMENTMETHOD = "/platform/v1/paymentmethod/delete";
	public static final String GET_CREDITCARD_BY_ID = "/platform/v1/creditcard/getCreditCardById/{creditCardId}";
    public static final String CREATE_CREDITCARD = "/platform/v1/creditcard/create";
    public static final String UPDATE_CREDITCARD = "/platform/v1/creditcard/update";
    public static final String DELETE_CREDITCARD = "/platform/v1/creditcard/delete";
}
