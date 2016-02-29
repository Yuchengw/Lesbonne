package com.lesbonne.paymentmethod;

/**
 * The interface for the PaymentMethodService
 * @author Jassica
 * @since 1
 * */
public interface PaymentMethodService {
	
	PaymentMethod persistPaymentMethod(PaymentMethod paymentMethod);
	
	PaymentMethod getPaymentMethodById(String paymentMethodId);
	
	PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod);
	
	void deletePaymentMethod(PaymentMethod paymentMethod);
	
//    PaymentMethod persistCreditCard(CreditCard creditCard);
//    
//    PaymentMethod getCreditCardById(String creditCardId);
//    
//    PaymentMethod updateCreditCard(CreditCard creditCard);
//    
//    void deleteCreditCard(CreditCard creditCard);
}
