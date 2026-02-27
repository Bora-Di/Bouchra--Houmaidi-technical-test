package com.progressoft.technicaltest.service;

import com.progressoft.technicaltest.dto.DealRequestDto;
import com.progressoft.technicaltest.dto.DealResponseDto;

public interface DealService {

    /**
     * Saves a new deal.
     *
     * @param dto the deal request data
     * @return the saved deal response
     * @throws com.progressoft.technicaltest.exception.DuplicateDealIdException if a deal with the same ID already exists
     */
    DealResponseDto save(DealRequestDto dto);
}