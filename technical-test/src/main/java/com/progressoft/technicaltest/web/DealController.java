package com.progressoft.technicaltest.web;

import com.progressoft.technicaltest.dto.DealRequestDto;
import com.progressoft.technicaltest.dto.DealResponseDto;
import com.progressoft.technicaltest.service.DealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/deals")
@RequiredArgsConstructor
@Slf4j
public class DealController {

    private final DealService dealService;

    /**
     * Creates a new deal.
     *
     * @param dto the deal request data
     * @return the created deal response with HTTP status 201
     */
    @PostMapping
    public ResponseEntity<DealResponseDto> save(@RequestBody @Valid DealRequestDto dto) {
        log.info("Received request to create deal with ID: {}", dto.id());

        DealResponseDto savedDeal = dealService.save(dto);

        log.info("Deal successfully created with ID: {}", savedDeal.id());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDeal);
    }
}