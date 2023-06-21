package com.count.icount.Trade.sell.Service;

import com.count.icount.Trade.sell.Dto.SellListResponseDto;
import com.count.icount.Trade.sell.Dto.SellRequestDto;
import com.count.icount.Trade.sell.Dto.SellResponseDto;
import com.count.icount.Trade.sell.Model.Entity.Sell;
import com.count.icount.Trade.sell.Repository.SellRepository;
import com.count.icount.exception.CGetSellException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SellService {
    private final SellRepository sellRepository;
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

    @Transactional
    public SellResponseDto get(Long id) {
        Sell sell = sellRepository.findById(id).orElse(null);
        return SellResponseDto.builder()
                .userName(sell.getUserName())
                .date(sell.getDate())
                .detailCode(sell.getDetailCode())
                .businessId(sell.getBusinessId())
                .build();
    }

    @Transactional
    public SellListResponseDto getAll() {
        List<Sell> sells = sellRepository.findAll();
        List<SellResponseDto> bd = new ArrayList<>();

        for(int i=0;i<sells.size();i++) {
            Sell s = sells.get(i);
            bd.add(new SellResponseDto(s.getId(), s.getBusinessId(),s.getUserName(),  s.getDetailCode(), s.getDate()));
        }

        return new SellListResponseDto(bd);
    }

    @Transactional
    public Long delete(Long id) {
        Sell sell = sellRepository.findById(id).orElseThrow(CGetSellException::new);
        sellRepository.delete(sell);
        return id;
    }

}
