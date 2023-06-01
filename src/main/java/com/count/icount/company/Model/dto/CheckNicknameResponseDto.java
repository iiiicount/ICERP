package com.count.icount.company.Model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckNicknameResponseDto {
    private boolean success;
    private String nickname;
    private String comCode;
}
