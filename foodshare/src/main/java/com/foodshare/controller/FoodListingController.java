package com.foodshare.controller;

import com.foodshare.model.FoodListing;
import com.foodshare.service.FoodListingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodListingController {

    @Autowired
    private FoodListingService foodListingService;

    @PostMapping
    public ResponseEntity<FoodListing> createListing(@Valid @RequestBody FoodListing listing) {
        FoodListing createdListing = foodListingService.createListing(listing);
        return new ResponseEntity<>(createdListing, HttpStatus.CREATED);
    }

    @GetMapping("/available")
    public ResponseEntity<List<FoodListing>> getAvailableListings() {
        return ResponseEntity.ok(foodListingService.getAvailableListings());
    }

    @PutMapping("/{id}/claim")
    public ResponseEntity<FoodListing> claimListing(@PathVariable Long id, @RequestParam String ngoName) {
        FoodListing claimedListing = foodListingService.claimListing(id, ngoName);
        return ResponseEntity.ok(claimedListing);
    }

    @PutMapping("/{id}/collected")
    public ResponseEntity<FoodListing> markAsCollected(@PathVariable Long id) {
        FoodListing collectedListing = foodListingService.markAsCollected(id);
        return ResponseEntity.ok(collectedListing);
    }
}