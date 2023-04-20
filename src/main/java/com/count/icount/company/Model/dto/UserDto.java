package com.count.icount.company.Model.dto;

import com.count.icount.company.Model.Entity.User;
import com.count.icount.company.Model.enums.UserType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String comCode;

    private Long id;

    private String uid;

    private String nickname;

    private String userType;

    public static UserDto Of(User user){
        return UserDto.builder()
                .id(user.getId())
                .comCode(user.getComCode())
                .uid(user.getUid())
                .nickname(user.getNickname())
                .userType(user.getUserType().getType())
                .build();
    }
}
