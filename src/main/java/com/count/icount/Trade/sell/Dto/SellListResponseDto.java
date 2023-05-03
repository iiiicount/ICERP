package com.count.icount.Trade.sell.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellListResponseDto {
    private List<SellResponseDto> sellDto;
}
