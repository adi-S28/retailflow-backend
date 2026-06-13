package org.mavensample.promotion.service;
import org.mavensample.promotion.model.LoyaltyAccount;

public interface LoyaltyService {

    LoyaltyAccount createAccount(Long customerId);

    LoyaltyAccount getAccount(Long customerId);

    LoyaltyAccount addPoints(Long customerId, int points);

    LoyaltyAccount redeemPoints(Long customerId, int points);
}