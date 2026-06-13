package org.mavensample.returns.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name ="refunds")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "refund_id", nullable = false)
    private Long refundId;

    @Column(name = "return_id", nullable = false)
    private Long returnId;

    @Column(name = "refund_amount", nullable = false)
    private Double refundAmount;

    @Column(name = "refund_method", nullable = false)
    private String refundMethod;

    @Column(name = "processed_date", nullable = false)
    private LocalDate processedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private RefundStatus status;

}
