package com.count.icount.trade.business.Service;

import com.count.icount.trade.bank.Model.Entity.Bank;
import com.count.icount.trade.bank.Repository.BankRepository;
import com.count.icount.trade.business.Model.Dto.BusinessRequestDto;
import com.count.icount.trade.business.Model.Dto.BusinessResponseDto;
import com.count.icount.trade.business.Model.Dto.GetBusinessResponseDto;
import com.count.icount.trade.business.Model.Entity.Business;
import com.count.icount.trade.business.Repository.BusinessRepository;
import com.count.icount.company.Model.Entity.Company;
import com.count.icount.exception.CBusinessException;
import com.count.icount.exception.handler.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BusinessService {
    private final BusinessRepository businessRepository;
    private final BankRepository bankRepository;

    public BusinessResponseDto saveBusiness(String comCode, BusinessRequestDto business) {
        var company = validateCompany(comCode);
        var bank = validateBank(business.getBankId());
        Business newBusiness = Business.of(business, company, bank);
        return BusinessResponseDto.of(businessRepository.save(newBusiness));
    }

    public List<GetBusinessResponseDto> getBusinesses(String comCode, Pageable page) {
        List<GetBusinessResponseDto> result = new ArrayList<>();
        var businesses = businessRepository.findAllByCompany_ComCode(comCode, page);

        if(businesses.size() > 0) {
            for(var business : businesses) {
                var response = GetBusinessResponseDto.of(business);
                result.add(response);
            }
        }
        return result;
    }

    private Company validateCompany(String comCode) {
        // 임시코드. 수정필요.
        Company company = new Company();
        company.setComCode(comCode);

        return company;
    }

    private Bank validateBank(Long bankId) {
        if(bankId == null || bankId == 0) {
           return null;
        }

        var searchResult = bankRepository.findById(bankId);
        if(searchResult.isEmpty()) {
            throw new CBusinessException("은행정보를 찾을 수 없습니다.", ErrorCode.NOT_EXIST_TARGET);
        }
        return searchResult.get();
    }
}
