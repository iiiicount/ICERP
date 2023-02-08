package com.count.icount.Trade.Sell.Service;

import com.count.icount.Trade.Sell.Dto.SellBoardRequestDto;
import com.count.icount.Trade.Sell.Dto.SellBoardResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class SellService {

    @Transactional
    public SellBoardResponseDto save(SellBoardRequestDto requestDto) {
        // 레포비토리
        // private final BoardRepository boardRepository;

        /*
        boardRepository.save(requestDto.getTitle(), requestDto.getContent()

                .build()
        );
        */

        return SellBoardResponseDto.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .build();
    }
}
