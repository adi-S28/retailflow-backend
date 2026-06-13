package org.mavensample.returns.model.service;
import org.mavensample.returns.model.ReturnRequest;
import java.util.List;

public interface ReturnRequestService {
    ReturnRequest createReturn(ReturnRequest returnRequest);
    ReturnRequest getReturn(Long returnId);
    List<ReturnRequest> getAllReturns();
    ReturnRequest updateReturn(Long returnId, ReturnRequest returnRequest);
    void deleteReturn(Long returnId);

}
