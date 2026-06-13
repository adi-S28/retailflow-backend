package org.mavensample.promotion.service;

import org.mavensample.promotion.model.LoyaltyAccount;
import org.mavensample.promotion.model.TierLevel;
import org.mavensample.promotion.repository.LoyaltyAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyServiceImpl implements LoyaltyService{
    private final LoyaltyAccountRepository
    loyaltyAccountRepository;

    public LoyaltyServiceImpl(LoyaltyAccountRepository loyaltyAccountRepository) {
        this.loyaltyAccountRepository = loyaltyAccountRepository;
    }

    @Override
    public LoyaltyAccount createAccount(Long customerId) {
        LoyaltyAccount account=new LoyaltyAccount();
        account.setCustomerId(customerId);
        account.setPointsBalance(0);
        account.setTierLevel(TierLevel.BRONZE);
        return loyaltyAccountRepository.save(account);

    }

    @Override
    public LoyaltyAccount getAccount(Long customerId) {
        return loyaltyAccountRepository.findByCustomerId(customerId).orElseThrow(()-> new RuntimeException("Loyalty account not found"));
    }

    @Override
    public LoyaltyAccount addPoints(Long customerId, int points) {
        LoyaltyAccount account= getAccount(customerId);

        int newBalance= account.getPointsBalance()+points;
        account.setPointsBalance(newBalance);

        account.setTierLevel(calculateTier(newBalance));


        return loyaltyAccountRepository.save(account);
    }

    @Override
    public LoyaltyAccount redeemPoints(Long customerId, int points) {
        LoyaltyAccount account= getAccount(customerId);
        if(account.getPointsBalance()<points){
            throw new RuntimeException("Insufficient loyalty points");
        }
        int newBalance= account.getPointsBalance()-points;
        account.setPointsBalance(newBalance);

        account.setTierLevel(calculateTier(newBalance));

        return loyaltyAccountRepository.save(account);
    }
    private TierLevel calculateTier(int points){
        if (points>=10000)
            return TierLevel.PLATINUM;
        if (points>=1000)
            return TierLevel.GOLD;
        if (points>=100)
            return TierLevel.SILVER;
        return TierLevel.BRONZE;
    }
}
