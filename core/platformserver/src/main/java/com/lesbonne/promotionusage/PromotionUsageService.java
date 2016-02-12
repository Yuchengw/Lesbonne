package com.lesbonne.promotionusage;

/**
 * @author Jassica
 * @since 1
 * */
public interface PromotionUsageService {

	PromotionUsage persistPromotionUsage(PromotionUsage promotionUsage);
	
	PromotionUsage getPromotionUsageById(String promotionUsageId);
	
	PromotionUsage updatePromotionUsage(PromotionUsage promotionUsage);
	
	void deletePromotionUsage(PromotionUsage promotionUsage);
}
