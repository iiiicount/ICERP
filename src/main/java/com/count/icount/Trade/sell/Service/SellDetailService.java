package com.count.icount.Trade.sell.Service;

import com.count.icount.Trade.sell.Dto.*;
import com.count.icount.Trade.sell.Model.Entity.Sell;
import com.count.icount.Trade.sell.Model.Entity.SellDetail;
import com.count.icount.Trade.sell.Repository.SellDetailRepository;
import com.count.icount.Trade.sell.Repository.SellRepository;
import com.count.icount.exception.CGetSellException;
import com.count.icount.exception.CSellDetailNotFoundException;
import com.count.icount.model.AuthUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SellDetailService {
    private final SellDetailRepository sellDetailRepository;
    private final SellRepository sellRepository;

//    public SellDetailResponseDto save(AuthUserInfo auth, SellDetailRequestDto sellDetailRequestDto) {
//        SellDetail sellDetail = SellDetail.of(sellDetailRequestDto);
//        sellDetail.setComCode(auth.getComCode());
//        sellDetail.setUserName(auth.getUserName());
//        sellDetailRepository.save(sellDetail);
//        return SellDetailResponseDto.of(sellDetail);
//    }

    public SellDetailListResponseDto save(AuthUserInfo auth, SellDetailListRequestDto sellDetailListRequestDto) {
        List<SellDetail> result = new ArrayList<>();
        for(var sd : sellDetailListRequestDto.getSellDetails()) {
            SellDetail sellDetail = sd;
            sellDetail.setUserName(auth.getUserName());
            sellDetail.setComCode(auth.getComCode());
            result.add(sellDetail);
            sellDetailRepository.save(sellDetail);
        }

        return SellDetailListResponseDto.of(result);
    }

    public SellDetailResponseDto getOne(AuthUserInfo auth, Long id){
        SellDetail sellDetail = sellDetailRepository.findByIdAndComCode(id, auth.getComCode()).orElseThrow(CSellDetailNotFoundException::new);
        return SellDetailResponseDto.of(sellDetail);
    }
    public SellDetailListResponseDto getAll(AuthUserInfo auth){
        List<SellDetail> sellDetails = sellDetailRepository.findByComCode(auth.getComCode()).orElseThrow(CSellDetailNotFoundException::new);

        return SellDetailListResponseDto.of(sellDetails);
    }
    public Long delete(AuthUserInfo auth, Long id){
        SellDetail sellDetail = sellDetailRepository.findByIdAndComCode(id, auth.getComCode()).orElseThrow(CSellDetailNotFoundException::new);
        sellDetailRepository.deleteById(id);
        return id;
    }
    public Long modify(AuthUserInfo auth, SellDetailListRequestDto sellDetailListRequestDto){
        for(var item : sellDetailListRequestDto.getSellDetails()) {
            SellDetail sellDetail = sellDetailRepository.findByIdAndComCode(item.getId(), auth.getComCode()).orElseThrow(CGetSellException::new);
            sellDetail = SellDetail.set(sellDetail, item);
        }
        return 1L;
    }
}
