package org.mavensample.promotion.service;
import org.mavensample.promotion.model.Promotion;
import java.util.List;


public interface PromotionService {
    Promotion createPromotion(Promotion promotion);
    Promotion getPromotion(Long promotionId);
    List<Promotion> getAllPromotions();
    Promotion updatePromotion(Long promotionId, Promotion promotion);
    void deletePromotion(Long promotionId);
}
