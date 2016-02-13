package com.lesbonne.promotion;

/**
 * @author Jassica
 * @since 1
 * */
public interface PromotionCodeDAO {
	
	void persistPromotionCode(PromotionCode promotionCode);
	
	PromotionCode getPromotionCodeById(String promotionCodeId);

	PromotionCode updatePromotionCode(PromotionCode promotionCode);
	
	void deletePromotionCode(PromotionCode promotionCode);
}
