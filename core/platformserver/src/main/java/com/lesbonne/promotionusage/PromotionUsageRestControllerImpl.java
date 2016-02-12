package com.lesbonne.promotionusage;

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
 * Rest controller implementation for PromotionUsage
 * @author jassica
 * @version 1
 */
@Controller
public class PromotionUsageRestControllerImpl implements PromotionUsageRestController {
	private static final Logger logger = LoggerFactory
			.getLogger(PromotionUsageRestControllerImpl.class);

	@Autowired
	private PromotionUsageService promotionUsageService;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = PromotionUsageRestURIConstants.GET_PROMOTIONUSAGE_BY_ID, produces = "application/json")
	public @ResponseBody ResponseEntity<PromotionUsage> getPromotionUsageById(
			@PathVariable String promotionUsageId) {
		PromotionUsage code = null;
		try {
			code = promotionUsageService.getPromotionUsageById(promotionUsageId);
		} catch (Exception e) {
			return new ResponseEntity<PromotionUsage>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PromotionUsage>(code, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, value = PromotionUsageRestURIConstants.UPDATE_PROMOTIONUSAGE, produces = "application/json")
	public @ResponseBody ResponseEntity<PromotionUsage> updatePromotionUsage(@RequestBody PromotionUsage promotionUsage) {
		PromotionUsage updatedCode = null;
		try {
			// TODO: Add validation on the basic required field
			if (promotionUsage == null) {
				return new ResponseEntity<PromotionUsage>(HttpStatus.BAD_REQUEST);
			}
			updatedCode = promotionUsageService.updatePromotionUsage(promotionUsage);
		} catch (Exception e) {
			return new ResponseEntity<PromotionUsage>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PromotionUsage>(updatedCode, HttpStatus.OK);	
	}

	@Override
	@RequestMapping(method=RequestMethod.POST, value=PromotionUsageRestURIConstants.CREATE_PROMOTIONUSAGE, produces = "application/json")
	public @ResponseBody ResponseEntity<PromotionUsage> addPromotionUsage(@RequestBody PromotionUsage promotionUsage) {
		PromotionUsage result = null;
		try {
			// TODO: Add required field validation
			if (promotionUsage == null) {
				return new ResponseEntity<PromotionUsage>(HttpStatus.BAD_REQUEST);
			}
			result = promotionUsageService.persistPromotionUsage(promotionUsage);
		} catch (Exception e) {
			return new ResponseEntity<PromotionUsage>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<PromotionUsage>(result, HttpStatus.OK);
	}

	@Override
	@RequestMapping(method=RequestMethod.DELETE, value=PromotionUsageRestURIConstants.DELETE_PROMOTIONUSAGE)
	public ResponseEntity<Boolean> deletePromotionUsage(@RequestBody PromotionUsage promotionUsage) {
		try {
			promotionUsageService.deletePromotionUsage(promotionUsage);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
