package org.mavensample.returns.controller;

import java.util.List;
import org.mavensample.returns.model.Refund;
import org.mavensample.returns.model.service.RefundService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refunds")
public class RefundController {
    private final RefundService refundService;


    public RefundController(RefundService refundService) {
        this.refundService = refundService;
    }

    @PostMapping
    public Refund createRefund(@RequestBody Refund refund){
        return refundService.createRefund(refund);
    }

    @GetMapping("/{id}")
    public Refund getRefund(@PathVariable Long id){
        return refundService.getRefund(id);
    }

    @GetMapping
    public List<Refund> getAllRefunds(){
        return refundService.getAllRefunds();
    }

    @PutMapping("/{id}")
    public Refund updateRefund(@PathVariable Long id, @RequestBody Refund refund){
        return refundService.updateRefund(id, refund);
    }

    @DeleteMapping("/{id}")
    public void deleteRefund(@PathVariable Long id){
        refundService.deleteRefund(id);
    }
}
