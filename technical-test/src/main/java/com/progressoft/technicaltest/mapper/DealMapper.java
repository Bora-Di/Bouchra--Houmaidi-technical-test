package com.progressoft.technicaltest.mapper;

import com.progressoft.technicaltest.dto.DealRequestDto;
import com.progressoft.technicaltest.dto.DealResponseDto;
import com.progressoft.technicaltest.entity.Deal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DealMapper {

    DealMapper INSTANCE = Mappers.getMapper(DealMapper.class);

    // Maps DealRequestDto to Deal entity
    Deal toEntity(DealRequestDto dto);

    // Maps Deal entity to DealResponseDto
    DealResponseDto toResponseEntity(Deal deal);
}