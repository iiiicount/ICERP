package com.count.icount.company.Model.Entity.PK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPK implements Serializable {
    private String comCode;
    private String nickname;
}
