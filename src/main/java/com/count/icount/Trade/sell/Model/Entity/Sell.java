package com.count.icount.Trade.sell.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long businessId;
    private String userName;
    private String detailCode;

    private String comCode;

    private Date date;

    public static Sell set(Sell sell1, Sell sell2) {
        sell1.setBusinessId(sell2.getBusinessId());
        sell1.setUserName(sell2.getUserName());
        sell1.setDetailCode(sell2.getDetailCode());
        sell1.setDate(sell2.getDate());
        return sell1;
    }
}
