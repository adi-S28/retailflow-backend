package org.mavensample.returns.controller;

import org.mavensample.returns.model.ReturnRequest;
import org.mavensample.returns.model.service.ReturnRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/returns")
public class ReturnRequestController {
    private final ReturnRequestService returnRequestService;

    public ReturnRequestController(ReturnRequestService returnRequestService) {
        this.returnRequestService = returnRequestService;
    }

    @PostMapping
    public ReturnRequest createReturn(@RequestBody ReturnRequest returnRequest){
        return returnRequestService.createReturn(returnRequest);
    }

    @GetMapping("/{id}")
    public ReturnRequest getReturn(@PathVariable Long id){
        return returnRequestService.getReturn(id);
    }

    @GetMapping
    public List<ReturnRequest> getAllReturn(){
        return returnRequestService.getAllReturns();
    }

    @PutMapping("/{id}")
    public ReturnRequest updateReturn(@PathVariable Long id,@RequestBody ReturnRequest returnRequest){
        return returnRequestService.updateReturn(id,returnRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteReturn(@PathVariable Long id){
        returnRequestService.deleteReturn(id);
    }
}
