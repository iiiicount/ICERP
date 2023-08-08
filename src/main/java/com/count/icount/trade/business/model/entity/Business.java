package com.count.icount.trade.business.model.entity;

import com.count.icount.trade.bank.model.entity.Bank;
import com.count.icount.trade.business.model.dto.BusinessRequestDto;
import com.count.icount.company.model.entity.Company;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="com_code", nullable = false)
    private Company company;

    // 거래처코드
    @Column(nullable = false, length = 20)
    private String code;

    // 거래처명
    @Column(nullable = false)
    private String name;

    // 사업자번호
    @Column(length = 10)
    private String businessNum;

    // 전화번호
    @Column(length = 20)
    private String tel;

    // 팩스번호
    @Column(length = 20)
    private String fax;

    // 주소
    private String address;

    // 계좌정보(은행)
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    // 계좌정보(계좌)
    private String accountNum;

    // 등록일시
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp enrollDt;

    // 수정일시
    @UpdateTimestamp
    @Column
    private Timestamp updateDt;

    public static Business of(BusinessRequestDto business, Company company, Bank bank){
        return Business.builder()
                .id(business.getId())
                .company(company)
                .code(business.getCode())
                .name(business.getName())
                .businessNum(business.getBusinessNum())
                .tel(business.getTel())
                .fax(business.getFax())
                .address(business.getAddress())
                .bank(bank)
                .accountNum(business.getAccountNum())
                .enrollDt(business.getEnrollDt())
                .updateDt(business.getUpdateDt())
                .build();
    }
}
