package com.count.icount.company.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JoinUserRequestDto {
    private String userName;
    private String comCode;
    private String password;
}
