package com.foodshare.repository;

import com.foodshare.model.FoodListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FoodListingRepository extends JpaRepository<FoodListing, Long> {

    List<FoodListing> findByStatus(String status);

    List<FoodListing> findByStatusAndExpiryTimeBefore(String status, LocalDateTime now);
}