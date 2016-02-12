package com.lesbonne.promotion;

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
 * Rest controller implementation for PromotionCode
 * @author jassica
 * @version 1
 */
@Controller
public class PromotionCodeRestControllerImpl implements PromotionCodeRestController {
	private static final Logger logger = LoggerFactory
			.getLogger(PromotionCodeRestControllerImpl.class);

	@Autowired
	private PromotionCodeService promotionCodeService;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = PromotionCodeRestURIConstants.GET_PROMOTIONCODE_BY_ID, produces = "application/json")
	public @ResponseBody ResponseEntity<PromotionCode> getPromotionCodeById(
			@PathVariable String promotionCodeId) {
		PromotionCode code = null;
		try {
			code = promotionCodeService.getPromotionCodeById(promotionCodeId);
		} catch (Exception e) {
			return new ResponseEntity<PromotionCode>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PromotionCode>(code, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, value = PromotionCodeRestURIConstants.UPDATE_PROMOTIONCODE, produces = "application/json")
	public @ResponseBody ResponseEntity<PromotionCode> updatePromotionCode(@RequestBody PromotionCode promotionCode) {
		PromotionCode updatedCode = null;
		try {
			// TODO: Add validation on the basic required field
			if (promotionCode == null) {
				return new ResponseEntity<PromotionCode>(HttpStatus.BAD_REQUEST);
			}
			updatedCode = promotionCodeService.updatePromotionCode(promotionCode);
		} catch (Exception e) {
			return new ResponseEntity<PromotionCode>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PromotionCode>(updatedCode, HttpStatus.OK);	
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value=PromotionCodeRestURIConstants.CREATE_PROMOTIONCODE, produces = "application/json")
	public @ResponseBody ResponseEntity<PromotionCode> addPromotionCode(@RequestBody PromotionCode promotionCode) {
		PromotionCode result = null;
		try {
			// TODO: Add required field validation
			if (promotionCode == null) {
				return new ResponseEntity<PromotionCode>(HttpStatus.BAD_REQUEST);
			}
			result = promotionCodeService.persistPromotionCode(promotionCode);
		} catch (Exception e) {
			return new ResponseEntity<PromotionCode>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PromotionCode>(result, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=PromotionCodeRestURIConstants.DELETE_PROMOTIONCODE)
	public ResponseEntity<Boolean> deletePromotionCode(@RequestBody PromotionCode promotionCode) {
		try {
			promotionCodeService.deletePromotionCode(promotionCode);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
