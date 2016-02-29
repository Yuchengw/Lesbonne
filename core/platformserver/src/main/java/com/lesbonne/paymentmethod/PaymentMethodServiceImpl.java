package com.lesbonne.paymentmethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jassica
 * @since 1
 * */
@Service("PaymentMethodService")
public class PaymentMethodServiceImpl implements PaymentMethodService {

	@Autowired
	PaymentMethodDAO paymentMethodDAO;
	
	@Override
	@Transactional
	public PaymentMethod persistPaymentMethod(PaymentMethod paymentMethod) {
		paymentMethodDAO.persistPaymentMethod(paymentMethod);
		return paymentMethod;
	}
	
	@Override
	@Transactional
	public PaymentMethod getPaymentMethodById(String paymentMethodId) {
		return paymentMethodDAO.getPaymentMethodById(paymentMethodId);
	}
	
	@Override
	@Transactional
	public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
		return paymentMethodDAO.updatePaymentMethod(paymentMethod);
	}
	
	@Override
	@Transactional
	public void deletePaymentMethod(PaymentMethod paymentMethod) {
		paymentMethodDAO.deletePaymentMethod(paymentMethod);
	}
}
