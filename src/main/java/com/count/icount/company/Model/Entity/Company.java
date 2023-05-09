package com.count.icount.company.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @Column(name="com_code")
    private String comCode;
    private String businessNumber;
    private String name;
    private String address;
    private String telephoneNum;
    private String ceo;
    private String businessType; // enum으로 가야할듯?

}
