package org.mavensample.returns.model.service;

import org.mavensample.returns.model.Refund;
import org.mavensample.returns.repository.RefundRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefundServiceImpl implements RefundService{

    private final RefundRepository refundRepository;

    public RefundServiceImpl(RefundRepository refundRepository) {
        this.refundRepository = refundRepository;
    }


    @Override
    public Refund createRefund(Refund refund) {
        return refundRepository.save(refund);
    }

    @Override
    public Refund getRefund(Long refundId) {
        return refundRepository.findById(refundId).orElseThrow(()->new RuntimeException("Refund not found"));
    }

    @Override
    public List<Refund> getAllRefunds() {
        return refundRepository.findAll();
    }

    @Override
    public Refund updateRefund(Long refundId, Refund refund) {
        Refund existingRefund = getRefund(refundId);
        existingRefund.setRefundAmount(refund.getRefundAmount());
        existingRefund.setRefundMethod(refund.getRefundMethod());
        existingRefund.setProcessedDate(refund.getProcessedDate());
        existingRefund.setStatus(refund.getStatus());
        return refundRepository.save(existingRefund);
    }

    @Override
    public void deleteRefund(Long refundId) {
        refundRepository.deleteById(refundId);
    }
}
