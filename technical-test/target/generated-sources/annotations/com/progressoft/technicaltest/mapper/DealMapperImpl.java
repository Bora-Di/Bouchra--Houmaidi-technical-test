package com.progressoft.technicaltest.mapper;

import com.progressoft.technicaltest.dto.DealRequestDto;
import com.progressoft.technicaltest.dto.DealResponseDto;
import com.progressoft.technicaltest.entity.Deal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-27T03:10:56+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class DealMapperImpl implements DealMapper {

    @Override
    public Deal toEntity(DealRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Deal.DealBuilder deal = Deal.builder();

        deal.id( dto.id() );
        deal.fromCurrency( dto.fromCurrency() );
        deal.toCurrency( dto.toCurrency() );
        deal.timestamp( dto.timestamp() );
        deal.amount( dto.amount() );

        return deal.build();
    }

    @Override
    public DealResponseDto toResponseEntity(Deal deal) {
        if ( deal == null ) {
            return null;
        }

        String id = null;
        Currency fromCurrency = null;
        Currency toCurrency = null;
        LocalDateTime timestamp = null;
        BigDecimal amount = null;

        id = deal.getId();
        fromCurrency = deal.getFromCurrency();
        toCurrency = deal.getToCurrency();
        timestamp = deal.getTimestamp();
        amount = deal.getAmount();

        DealResponseDto dealResponseDto = new DealResponseDto( id, fromCurrency, toCurrency, timestamp, amount );

        return dealResponseDto;
    }
}
