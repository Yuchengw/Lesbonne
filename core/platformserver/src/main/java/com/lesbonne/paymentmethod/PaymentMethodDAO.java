package com.lesbonne.paymentmethod;

/**
 * @author jassica
 * @since 1
 * */
public interface PaymentMethodDAO {

	void persistPaymentMethod(PaymentMethod paymentMethod);
	
	void deletePaymentMethod(PaymentMethod paymentMethod);
	
	PaymentMethod getPaymentMethodById(String paymentMethodId);
	
	PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);
}
