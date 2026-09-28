package com.foodshare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_listings")
public class FoodListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Food title is required")
    private String title;

    private String description;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotBlank(message = "Donor name is required")
    private String donorName;

    private String donorContact;

    @NotNull(message = "Safe-to-eat time is required")
    @Future(message = "Expiry time must be in the future")
    private LocalDateTime expiryTime;

    private String status = "AVAILABLE"; // AVAILABLE, CLAIMED, COLLECTED, EXPIRED

    private String claimedByNgo;

    public FoodListing() {
    }

    public FoodListing(String title, String description, Integer quantity, String donorName, String donorContact, LocalDateTime expiryTime) {
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.donorName = donorName;
        this.donorContact = donorContact;
        this.expiryTime = expiryTime;
        this.status = "AVAILABLE";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorContact() {
        return donorContact;
    }

    public void setDonorContact(String donorContact) {
        this.donorContact = donorContact;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClaimedByNgo() {
        return claimedByNgo;
    }

    public void setClaimedByNgo(String claimedByNgo) {
        this.claimedByNgo = claimedByNgo;
    }
}