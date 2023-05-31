package com.count.icount.Trade.sell.Dto;

import com.count.icount.Trade.sell.Model.Entity.SellDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellDetailListResponseDto {
    private List<SellDetail> sellDetails;

    public static SellDetailListResponseDto of(List<SellDetail> list) {
        return builder().sellDetails(list).build();
    }
}
