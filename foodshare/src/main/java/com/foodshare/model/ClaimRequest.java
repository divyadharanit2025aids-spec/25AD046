package com.foodshare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "claim_requests")
public class ClaimRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long foodListingId;
    private Long ngoUserId;

    private String status; // PENDING, APPROVED, REJECTED

    private LocalDateTime createdAt;

    public ClaimRequest() {
        this.createdAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public ClaimRequest(Long foodListingId, Long ngoUserId, String status) {
        this.foodListingId = foodListingId;
        this.ngoUserId = ngoUserId;
        this.status = (status != null) ? status : "PENDING";
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getFoodListingId() { return foodListingId; }
    public void setFoodListingId(Long foodListingId) { this.foodListingId = foodListingId; }

    public Long getNgoUserId() { return ngoUserId; }
    public void setNgoUserId(Long ngoUserId) { this.ngoUserId = ngoUserId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}