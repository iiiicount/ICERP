package com.count.icount.trade.sell.model.dto;

import com.count.icount.trade.sell.model.entity.Sell;
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
    private List<Sell> sellDto;

    public static SellListResponseDto of(List<Sell> sells) {
        return builder().sellDto(sells).build();
    }
}
