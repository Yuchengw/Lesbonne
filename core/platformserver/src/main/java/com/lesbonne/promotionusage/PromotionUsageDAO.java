package com.lesbonne.promotionusage;

/**
 * @author Jassica
 * @since 1
 * */
public interface PromotionUsageDAO {
	
	void persistPromotionUsage(PromotionUsage promotionUsage);
	
	PromotionUsage getPromotionUsageById(String promotionUsageId);

	PromotionUsage updatePromotionUsage(PromotionUsage promotionUsage);
	
	void deletePromotionUsage(PromotionUsage promotionUsage);
}
