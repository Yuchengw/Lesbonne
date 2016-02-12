package com.lesbonne.promotion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface for the PromotionCode Rest Service
 * @author jassica
 * @version 1
 *
 */
public interface PromotionCodeRestController {
	public ResponseEntity<PromotionCode> getPromotionCodeById(@PathVariable String promotionCodeId);

	public ResponseEntity<PromotionCode> updatePromotionCode(@RequestBody final PromotionCode promotionCode);

	public ResponseEntity<PromotionCode> addPromotionCode(@RequestBody PromotionCode promotionCode);

	public ResponseEntity<Boolean> deletePromotionCode(@PathVariable PromotionCode promotionCode);
}
