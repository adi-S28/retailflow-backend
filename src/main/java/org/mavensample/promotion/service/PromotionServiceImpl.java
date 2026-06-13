package org.mavensample.promotion.service;
import org.mavensample.promotion.model.Promotion;
import org.mavensample.promotion.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService{
        private final PromotionRepository promotionRepository;

        public PromotionServiceImpl(PromotionRepository promotionRepository){
            this.promotionRepository=promotionRepository;
    }

    @Override
    public Promotion createPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion getPromotion(Long promotionId) {
        return promotionRepository.findById(promotionId).orElseThrow(()->new RuntimeException("Promotion not found"));
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion updatePromotion(Long promotionId, Promotion promotion) {
            Promotion existingPromotion=getPromotion(promotionId);
            existingPromotion.setName(promotion.getName());
            existingPromotion.setDiscountType(promotion.getDiscountType());
            existingPromotion.setDiscountValue(promotion.getDiscountValue());
            existingPromotion.setStartDate(promotion.getStartDate());
            existingPromotion.setEndDate(promotion.getEndDate());
            existingPromotion.setApplicationScope(promotion.getApplicationScope());
            existingPromotion.setStatus(promotion.getStatus());
            return promotionRepository.save(existingPromotion);
    }

    @Override
    public void deletePromotion(Long promotionId) {
            promotionRepository.deleteById(promotionId);


    }
}
