package com.count.icount.Trade.sell.Dto;

import com.count.icount.Trade.sell.Model.Entity.Sell;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellListRequestDto {
    private List<Sell> sellDto;

    public static SellListRequestDto of(List<Sell> sells) {
        return builder().sellDto(sells).build();
    }
}
