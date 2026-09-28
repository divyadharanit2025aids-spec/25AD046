package com.foodshare.service;

import com.foodshare.model.ClaimRequest;
import com.foodshare.repository.ClaimRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimRequestService {

    @Autowired
    private ClaimRequestRepository claimRequestRepository;

    public ClaimRequest createClaimRequest(ClaimRequest claimRequest) {
        return claimRequestRepository.save(claimRequest);
    }

    public List<ClaimRequest> getAllClaimRequests() {
        return claimRequestRepository.findAll();
    }

    public Optional<ClaimRequest> getClaimRequestById(Long id) {
        return claimRequestRepository.findById(id);
    }

    public List<ClaimRequest> getClaimsByNgoId(Long ngoUserId) {
        return claimRequestRepository.findByNgoUserId(ngoUserId);
    }

    public ClaimRequest updateClaimStatus(Long id, String status) {
        Optional<ClaimRequest> existingClaim = claimRequestRepository.findById(id);
        if (existingClaim.isPresent()) {
            ClaimRequest claim = existingClaim.get();
            claim.setStatus(status);
            return claimRequestRepository.save(claim);
        }
        return null;
    }
}