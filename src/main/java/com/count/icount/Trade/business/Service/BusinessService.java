package com.count.icount.Trade.business.Service;

import com.count.icount.Trade.bank.Model.Entity.Bank;
import com.count.icount.Trade.bank.Repository.BankRepository;
import com.count.icount.Trade.business.Model.Dto.BusinessRequestDto;
import com.count.icount.Trade.business.Model.Dto.BusinessResponseDto;
import com.count.icount.Trade.business.Model.Entity.Business;
import com.count.icount.Trade.business.Repository.BusinessRepository;
import com.count.icount.company.Model.Entity.Company;
import com.count.icount.exception.CBusinessException;
import com.count.icount.exception.handler.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
