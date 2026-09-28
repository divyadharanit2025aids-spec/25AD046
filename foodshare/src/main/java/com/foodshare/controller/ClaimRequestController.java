package com.foodshare.controller;

import com.foodshare.model.ClaimRequest;
import com.foodshare.service.ClaimRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimRequestController {

    @Autowired
    private ClaimRequestService claimRequestService;

    @PostMapping
    public ClaimRequest createClaim(@RequestBody ClaimRequest claimRequest) {
        return claimRequestService.createClaimRequest(claimRequest);
    }

    @GetMapping
    public List<ClaimRequest> getAllClaims() {
        return claimRequestService.getAllClaimRequests();
    }

    @GetMapping("/{id}")
    public ClaimRequest getClaimById(@PathVariable Long id) {
        return claimRequestService.getClaimRequestById(id).orElse(null);
    }

    @PutMapping("/{id}/status")
    public ClaimRequest updateStatus(@PathVariable Long id, @RequestParam String status) {
        return claimRequestService.updateClaimStatus(id, status);
    }
}