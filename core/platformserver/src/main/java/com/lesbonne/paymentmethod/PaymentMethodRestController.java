package com.lesbonne.paymentmethod;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface for the PaymentMethod Rest Service
 * @author jassica
 * @version 1
 *
 */
public interface PaymentMethodRestController {
	public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable String paymentMethodId);

	public ResponseEntity<PaymentMethod> updatePaymentMethod(@RequestBody final PaymentMethod paymentMethod);

	public ResponseEntity<PaymentMethod> addPaymentMethod(@RequestBody PaymentMethod paymentMethod);

	public ResponseEntity<Boolean> deletePaymentMethod(@PathVariable PaymentMethod paymentMethod);
	
	public ResponseEntity<CreditCard> getCreditCardById(@PathVariable String creditCardId);

    public ResponseEntity<CreditCard> updateCreditCard(@RequestBody final CreditCard creditCard);

    public ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard creditCard);

    public ResponseEntity<Boolean> deleteCreditCard(@PathVariable CreditCard creditCard);
}
