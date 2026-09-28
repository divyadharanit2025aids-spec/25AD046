package com.foodshare.service;

import com.foodshare.model.FoodListing;
import com.foodshare.repository.FoodListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodListingService {

    @Autowired
    private FoodListingRepository repository;

    public FoodListing createListing(FoodListing listing) {
        listing.setStatus("AVAILABLE");
        return repository.save(listing);
    }

    public List<FoodListing> getAvailableListings() {
        return repository.findByStatus("AVAILABLE");
    }

    public FoodListing claimListing(Long id, String ngoName) {
        FoodListing listing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food listing not found with id: " + id));

        if ("CLAIMED".equals(listing.getStatus()) || "COLLECTED".equals(listing.getStatus())) {
            throw new RuntimeException("This food listing is already claimed or collected.");
        }

        if (listing.getExpiryTime().isBefore(LocalDateTime.now())) {
            listing.setStatus("EXPIRED");
            repository.save(listing);
            throw new RuntimeException("Cannot claim: Safe-to-eat time has expired.");
        }

        listing.setStatus("CLAIMED");
        listing.setClaimedByNgo(ngoName);
        return repository.save(listing);
    }

    public FoodListing markAsCollected(Long id) {
        FoodListing listing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food listing not found with id: " + id));

        if (!"CLAIMED".equals(listing.getStatus())) {
            throw new RuntimeException("Only claimed food listings can be marked as collected.");
        }

        listing.setStatus("COLLECTED");
        return repository.save(listing);
    }
}
