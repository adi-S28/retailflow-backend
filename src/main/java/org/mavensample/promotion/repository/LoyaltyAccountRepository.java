package org.mavensample.promotion.repository;


import org.mavensample.promotion.model.LoyaltyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LoyaltyAccountRepository extends JpaRepository<LoyaltyAccount, Long>{
    Optional<LoyaltyAccount>
    findByCustomerId(Long CustomerId);
}
