package com.lesbonne.promotionusage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jassica
 * @since 1
 * */
@Service
public class PromotionUsageServiceImpl implements PromotionUsageService {
    
    @Autowired
    PromotionUsageDAO promotionUsageDAO;
    
    @Override
    @Transactional
    public PromotionUsage persistPromotionUsage(PromotionUsage promotionUsage) {
        promotionUsageDAO.persistPromotionUsage(promotionUsage);
        return promotionUsage;
    }
    
    @Override
    @Transactional
    public PromotionUsage getPromotionUsageById(String promotionUsageId) {
        return promotionUsageDAO.getPromotionUsageById(promotionUsageId);
    }
    
    @Override
    @Transactional
    public PromotionUsage updatePromotionUsage(PromotionUsage promotionUsage) {
        return promotionUsageDAO.updatePromotionUsage(promotionUsage);
    }
    
    @Override
    @Transactional
    public void deletePromotionUsage(PromotionUsage promotionUsage) {
        promotionUsageDAO.deletePromotionUsage(promotionUsage);
    }
}
