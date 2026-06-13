package org.mavensample.returns.model.service;

import org.mavensample.returns.model.Refund;

import java.util.List;

public interface RefundService {
    Refund createRefund(Refund refund);
    Refund getRefund(Long refundId);
    List<Refund> getAllRefunds();
    Refund updateRefund(Long refundId, Refund refund);
    void deleteRefund(Long refundId);
}
