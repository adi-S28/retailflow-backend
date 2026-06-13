package org.mavensample.promotion.controller;

import org.mavensample.promotion.model.LoyaltyAccount;
import org.mavensample.promotion.service.LoyaltyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loyalty")
public class LoyaltyController {

    private final LoyaltyService loyaltyService;

    public LoyaltyController(LoyaltyService loyaltyService) {
        this.loyaltyService = loyaltyService;
    }


    @PostMapping("/create/{customerId}")
    public LoyaltyAccount createAccount(@PathVariable Long customerId) {
        return loyaltyService.createAccount(customerId);
    }

    @GetMapping("/{customerId}")
    public LoyaltyAccount getAccount(@PathVariable Long customerId){
        return loyaltyService.getAccount(customerId);
    }

    @PostMapping("/{customerId}/add-points/{points}")
    public LoyaltyAccount addPoints(@PathVariable Long customerId, @PathVariable int points){
        return loyaltyService.addPoints(customerId, points);
    }

    @PostMapping("/{customerId}/redeem-points/{points}")
    public LoyaltyAccount redeemPoints(@PathVariable Long customerId, @PathVariable int points){
        return loyaltyService.redeemPoints(customerId, points);
    }
}
