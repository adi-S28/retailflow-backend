package org.mavensample.promotion.controller;
import org.mavensample.promotion.model.Promotion;
import org.mavensample.promotion.service.PromotionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService){
        this.promotionService=promotionService;
    }

   @PostMapping
   public Promotion createPromotion(@RequestBody Promotion promotion){
        return promotionService.createPromotion(promotion);
   }
   @GetMapping("/{id}")
    public Promotion getPromotion(@PathVariable Long id){
        return promotionService.getPromotion(id);
    }

    @GetMapping
    public  List<Promotion> getAllpromotions(){
        return promotionService.getAllPromotions();
    }

    @PutMapping("/{id}")
    public Promotion updatePromotion(@PathVariable Long id, @RequestBody Promotion promotion){
        return promotionService.updatePromotion(id, promotion);
    }

    @DeleteMapping("/{id}")
    public void deletePromotion(@PathVariable Long id){
        promotionService.deletePromotion(id);
    }
}