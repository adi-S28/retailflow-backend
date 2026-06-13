package org.mavensample.returns.model.service;

import org.mavensample.returns.model.ReturnRequest;
import org.mavensample.returns.repository.ReturnRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrunRequestServiceImpl implements ReturnRequestService{

    private final ReturnRequestRepository returnRequestRepository;

    public RetrunRequestServiceImpl(ReturnRequestRepository returnRequestRepository) {
        this.returnRequestRepository = returnRequestRepository;
    }

    @Override
    public ReturnRequest createReturn(ReturnRequest returnRequest) {
        return returnRequestRepository.save(returnRequest);
    }

    @Override
    public ReturnRequest getReturn(Long returnId) {
        return returnRequestRepository.findById(returnId).orElseThrow(()->new RuntimeException("Return request not found"));
    }

    @Override
    public List<ReturnRequest> getAllReturns() {
        return returnRequestRepository.findAll();
    }

    @Override
    public ReturnRequest updateReturn(Long returnId, ReturnRequest returnRequest) {
        ReturnRequest existingReturn=getReturn(returnId);

        existingReturn.setOrderId(returnRequest.getOrderId());
        existingReturn.setCustomerId(returnRequest.getCustomerId());
        existingReturn.setReason(returnRequest.getReason());
        existingReturn.setReturnDate(returnRequest.getReturnDate());
        existingReturn.setStatus(returnRequest.getStatus());


        return returnRequestRepository.save(existingReturn);
    }

    @Override
    public void deleteReturn(Long returnId) {
        returnRequestRepository.deleteById(returnId);
    }
}
