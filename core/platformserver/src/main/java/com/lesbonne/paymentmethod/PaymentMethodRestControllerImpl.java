package com.lesbonne.paymentmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Rest controller implementation for PaymentMethod
 * @author jassica
 * @version 1
 */
@Controller
public class PaymentMethodRestControllerImpl implements PaymentMethodRestController {
	private static final Logger logger = LoggerFactory
			.getLogger(PaymentMethodRestControllerImpl.class);

	@Autowired
	private PaymentMethodService paymentMethodService;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = PaymentMethodRestURIConstants.GET_PAYMENTMETHOD_BY_ID, produces = "application/json")
	public @ResponseBody ResponseEntity<PaymentMethod> getPaymentMethodById(
			@PathVariable String paymentMethodId) {
	    PaymentMethod post = null;
		try {
			post = paymentMethodService.getPaymentMethodById(paymentMethodId);
		} catch (Exception e) {
			return new ResponseEntity<PaymentMethod>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PaymentMethod>(post, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, value = PaymentMethodRestURIConstants.UPDATE_PAYMENTMETHOD, produces = "application/json")
	public @ResponseBody ResponseEntity<PaymentMethod> updatePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
	    PaymentMethod updatedPaymentMethod = null;
		try {
			// TODO: Add validation on the basic required field
			if (paymentMethod == null) {
				return new ResponseEntity<PaymentMethod>(HttpStatus.BAD_REQUEST);
			}
			updatedPaymentMethod = paymentMethodService.updatePaymentMethod(paymentMethod);
		} catch (Exception e) {
			return new ResponseEntity<PaymentMethod>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PaymentMethod>(updatedPaymentMethod, HttpStatus.OK);	
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value=PaymentMethodRestURIConstants.CREATE_PAYMENTMETHOD, produces = "application/json")
	public @ResponseBody ResponseEntity<PaymentMethod> addPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
	    PaymentMethod result = null;
		try {
			// TODO: Add required field validation
			if (paymentMethod == null) {
				return new ResponseEntity<PaymentMethod>(HttpStatus.BAD_REQUEST);
			}
			result = paymentMethodService.persistPaymentMethod(paymentMethod);
		} catch (Exception e) {
			return new ResponseEntity<PaymentMethod>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PaymentMethod>(result, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=PaymentMethodRestURIConstants.DELETE_PAYMENTMETHOD)
	public ResponseEntity<Boolean> deletePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
		try {
			paymentMethodService.deletePaymentMethod(paymentMethod);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@Override
    @RequestMapping(method = RequestMethod.GET, value = PaymentMethodRestURIConstants.GET_CREDITCARD_BY_ID, produces = "application/json")
	public ResponseEntity<CreditCard> getCreditCardById(@PathVariable String creditCardId) {
        CreditCard card = null;
        try {
            PaymentMethod method = paymentMethodService.getPaymentMethodById(creditCardId);
            card = new CreditCard(method);
        } catch (Exception e) {
            return new ResponseEntity<CreditCard>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CreditCard>(card, HttpStatus.OK);
    }

	
	

    @Override
    public ResponseEntity<CreditCard> updateCreditCard(CreditCard creditCard) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    @RequestMapping(method=RequestMethod.POST, value=PaymentMethodRestURIConstants.CREATE_CREDITCARD, produces = "application/json")
    public @ResponseBody ResponseEntity<CreditCard> addCreditCard(@RequestBody CreditCard creditCard) {
        CreditCard result = null;
        try {
            // TODO: Add required field validation
            if (creditCard == null) {
                return new ResponseEntity<CreditCard>(HttpStatus.BAD_REQUEST);
            }
            PaymentMethod method = paymentMethodService.persistPaymentMethod(creditCard.convertToParent());
            result = new CreditCard(method);
        } catch (Exception e) {
            return new ResponseEntity<CreditCard>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CreditCard>(result, HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Boolean> deleteCreditCard(CreditCard creditCard) {
        // TODO Auto-generated method stub
        return null;
    }
}
