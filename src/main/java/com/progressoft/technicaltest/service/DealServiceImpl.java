package com.progressoft.technicaltest.service;

import com.progressoft.technicaltest.dto.DealRequestDto;
import com.progressoft.technicaltest.dto.DealResponseDto;
import com.progressoft.technicaltest.entity.Deal;
import com.progressoft.technicaltest.exception.DuplicateDealIdException;
import com.progressoft.technicaltest.mapper.DealMapper;
import com.progressoft.technicaltest.repository.DealRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;
    private final DealMapper dealMapper;

    @Override
    @Transactional
    public DealResponseDto save(DealRequestDto dto) {
        log.info("Attempting to save deal with ID: {}", dto.id());

        // Check for duplicate ID
        if (dealRepository.existsById(dto.id())) {
            log.warn("Duplicate deal ID detected: {}. Operation aborted.", dto.id());
            throw new DuplicateDealIdException("Deal ID already exists: " + dto.id());
        }

        // Map DTO to entity
        Deal dealToSave = dealMapper.toEntity(dto);

        // Save to DB
        Deal savedDeal = dealRepository.save(dealToSave);
        log.info("Deal saved successfully with ID: {}", savedDeal.getId());

        // Map back to response DTO
        return dealMapper.toResponseEntity(savedDeal);
    }
}