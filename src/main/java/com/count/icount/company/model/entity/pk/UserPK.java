package com.count.icount.company.model.entity.pk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPK implements Serializable {
    private String comCode;
    private String userName;
}
