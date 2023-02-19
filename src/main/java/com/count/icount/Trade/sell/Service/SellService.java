package com.count.icount.Trade.sell.Service;

import com.count.icount.Trade.sell.Dto.SellRequestDto;
import com.count.icount.Trade.sell.Dto.SellResponseDto;
import com.count.icount.Trade.sell.Model.Entity.Sell;
import com.count.icount.Trade.sell.Repository.SellRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Log4j2
public class SellService {
    SellRepository sellRepository;
    @Transactional
    public SellResponseDto save(SellRequestDto requestDto) {
        sellRepository.save(Sell.builder()
                .userName(requestDto.getUserName())
                .businessId(requestDto.getBusinessId())
                .detailCode(requestDto.getDetailCode())
                .date(new Date())
                .build());

        return SellResponseDto.builder()
                .userName(requestDto.getUserName())
                .businessId(requestDto.getBusinessId())
                .detailCode(requestDto.getDetailCode())
                .date(new Date())
                .build();
    }

   /* @Transactional
    public SellResponseDto get(Long id) {
        Sell sell = sellRepository.findById(id).orElse(null);
        return SellResponseDto.builder()
                .userName(sell.getUserName())
                .date(sell.getDate())
                .detailCode(sell.getDetailCode())
                .businessId(sell.getBusinessId())
                .build();
    }*/
}
