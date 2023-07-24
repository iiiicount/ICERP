package com.count.icount.trade.business.service;

import com.count.icount.trade.bank.model.entity.Bank;
import com.count.icount.trade.bank.repository.BankRepository;
import com.count.icount.trade.business.model.dto.BusinessRequestDto;
import com.count.icount.trade.business.model.dto.BusinessResponseDto;
import com.count.icount.trade.business.model.dto.GetBusinessResponseDto;
import com.count.icount.trade.business.model.entity.Business;
import com.count.icount.trade.business.repository.BusinessRepository;
import com.count.icount.company.model.entity.Company;
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

    public BusinessResponseDto deleteBusiness(String comCode, Long id) {
        var target = businessRepository.findById(id);
        if(target.isEmpty()){
            return null;
        }
        var result = BusinessResponseDto.of(target.get());
        businessRepository.delete(target.get());
        return result;
    }

    public GetBusinessResponseDto updateBusiness(Long id, String comCode, BusinessRequestDto business) {
        var findResult = businessRepository.findById(id);
        if(findResult.isEmpty()) {
            return null;
        }

        business.setId(id);
        var company = validateCompany(comCode);
        var bank = validateBank(business.getBankId());
        var target = Business.of(business, company, bank);
        return GetBusinessResponseDto.of(businessRepository.save(target));
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
