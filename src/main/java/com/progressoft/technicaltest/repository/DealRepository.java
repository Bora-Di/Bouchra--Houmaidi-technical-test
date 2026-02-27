package com.progressoft.technicaltest.repository;

import com.progressoft.technicaltest.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal, String> {

    // Checks if a deal with the given ID already exists
    boolean existsById(String id);
}