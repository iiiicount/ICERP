package com.count.icount.trade.sell.model.dto;

import com.count.icount.trade.sell.model.entity.SellDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellDetailListRequestDto {
    private List<SellDetail> sellDetails;

    public static SellDetailListRequestDto of(List<SellDetail> list) {
        return builder().sellDetails(list).build();
    }
}
