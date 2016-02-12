package com.lesbonne.promotionusage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The interface for the PromotionUsage Rest Service
 * @author jassica
 * @version 1
 *
 */
public interface PromotionUsageRestController {
	public ResponseEntity<PromotionUsage> getPromotionUsageById(@PathVariable String promotionUsageId);

	public ResponseEntity<PromotionUsage> updatePromotionUsage(@RequestBody final PromotionUsage promotionUsage);

	public ResponseEntity<PromotionUsage> addPromotionUsage(@RequestBody PromotionUsage promotionUsage);

	public ResponseEntity<Boolean> deletePromotionUsage(@PathVariable PromotionUsage promotionUsage);
}
