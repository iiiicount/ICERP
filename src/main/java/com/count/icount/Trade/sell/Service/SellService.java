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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SellService {
    private final SellDetailRepository sellDetailRepository;
    private final SellRepository sellRepository;

//    public SellDetailResponseDto save(AuthUserInfo auth, SellDetailRequestDto sellDetailRequestDto) {
//        SellDetail sellDetail = SellDetail.of(sellDetailRequestDto);
//        sellDetail.setComCode(auth.getComCode());
//        sellDetail.setUserName(auth.getUserName());
//        sellDetailRepository.save(sellDetail);
//        return SellDetailResponseDto.of(sellDetail);
//    }

    public SellListResponseDto save(AuthUserInfo auth, SellListRequestDto sellListRequestDto) {
        List<Sell> result = new ArrayList<>();
        for(var sd : sellListRequestDto.getSellDto()) {
            Sell sell = sd;
            sell.setUserName(auth.getUserName());
            sell.setComCode(auth.getComCode());
            result.add(sell);
            sellRepository.save(sell);
        }

        return SellListResponseDto.of(result);
    }

    public SellResponseDto getOne(AuthUserInfo auth, Long id){
        Sell sell= sellRepository.findByIdAndComCode(id, auth.getComCode()).orElseThrow(CSellDetailNotFoundException::new);
        return SellResponseDto.of(sell);
    }
    public SellListResponseDto getAll(AuthUserInfo auth){
        List<Sell> sell = sellRepository.findByComCode(auth.getComCode()).orElseThrow(CSellDetailNotFoundException::new);

        return SellListResponseDto.of(sell);
    }
    public Long delete(AuthUserInfo auth, Long id){
        Sell sell = sellRepository.findByIdAndComCode(id, auth.getComCode()).orElseThrow(CSellDetailNotFoundException::new);
        sellRepository.deleteById(id);
        return id;
    }
    public Long modify(AuthUserInfo auth, SellListRequestDto sellListRequestDto){
        for(var item : sellListRequestDto.getSellDto()) {
            Sell sell = sellRepository.findByIdAndComCode(item.getId(), auth.getComCode()).orElseThrow(CGetSellException::new);
            sell = Sell.set(sell, item);
        }
        return 1L;
    }

}
