package org.mavensample.promotion.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name ="loyalty_accounts")
public class LoyaltyAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loyalty_id", nullable = false)
    private Long loyaltyId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "point_balance", nullable = false)
    private Integer pointsBalance=0;

    @Enumerated(EnumType.STRING)
    @Column(name = "tier_level", nullable = false)
    private TierLevel tierLevel;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdated;

    @PrePersist
    public void onCreate(){
        lastUpdated=LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        lastUpdated=LocalDateTime.now();
    }

}
