package com.lesbonne.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jassica
 * @since 1
 * */
@Service
public class PromotionCodeServiceImpl implements PromotionCodeService {
    
    @Autowired
    PromotionCodeDAO promotionCodeDAO;
    
    @Override
    @Transactional
    public PromotionCode persistPromotionCode(PromotionCode promotionCode) {
        promotionCodeDAO.persistPromotionCode(promotionCode);
        return promotionCode;
    }
    
    @Override
    @Transactional
    public PromotionCode getPromotionCodeById(String promotionCodeId) {
        return promotionCodeDAO.getPromotionCodeById(promotionCodeId);
    }
    
    @Override
    @Transactional
    public PromotionCode updatePromotionCode(PromotionCode promotionCode) {
        return promotionCodeDAO.updatePromotionCode(promotionCode);
    }
    
    @Override
    @Transactional
    public void deletePromotionCode(PromotionCode promotionCode) {
        promotionCodeDAO.deletePromotionCode(promotionCode);
    }
}
