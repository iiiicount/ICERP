package com.count.icount.Trade.sell.Service;

import com.count.icount.Trade.sell.Dto.*;
import com.count.icount.Trade.sell.Model.Entity.Sell;
import com.count.icount.Trade.sell.Model.Entity.SellDetail;
import com.count.icount.Trade.sell.Repository.SellDetailRepository;
import com.count.icount.Trade.sell.Repository.SellRepository;
import com.count.icount.exception.CGetSellException;
import com.count.icount.exception.CSellDetailNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SellDetailService {
    private final SellDetailRepository sellDetailRepository;
    private final SellRepository sellRepository;

    public SellDetailResponseDto save(SellDetailRequestDto sellDetailRequestDto) {
        SellDetail sellDetail = SellDetail.of(sellDetailRequestDto);
        sellDetailRepository.save(sellDetail);
        return SellDetailResponseDto.of(sellDetail);
    }
    public SellDetailResponseDto getOne(Long id){
        SellDetail sellDetail = sellDetailRepository.findById(id).orElseThrow(CSellDetailNotFoundException::new);
        return SellDetailResponseDto.of(sellDetail);
    }
    public SellDetailListResponseDto getAll(){
        List<SellDetail> sellDetails = sellDetailRepository.findAll();

        return SellDetailListResponseDto.of(sellDetails);
    }
    public Long delete(Long id){
        SellDetail sellDetail = sellDetailRepository.findById(id).orElseThrow(CSellDetailNotFoundException::new);
        sellDetailRepository.deleteById(id);
        return id;
    }
    public void modify(){}
}
