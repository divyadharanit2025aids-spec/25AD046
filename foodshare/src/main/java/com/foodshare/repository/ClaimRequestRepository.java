package com.foodshare.repository;

import com.foodshare.model.ClaimRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRequestRepository extends JpaRepository<ClaimRequest, Long> {
    List<ClaimRequest> findByNgoUserId(Long ngoUserId);
    List<ClaimRequest> findByFoodListingId(Long foodListingId);
}