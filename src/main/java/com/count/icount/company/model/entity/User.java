package com.count.icount.company.model.entity;

import com.count.icount.company.model.entity.pk.UserPK;
import com.count.icount.company.model.dto.UserDto;
import com.count.icount.company.model.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(UserPK.class)
public class User {
    @Id
    private String comCode;
    private Long id;

    private String uid;
    @Id
    private String userName;

    private UserType userType;

    public static User of(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .uid(userDto.getUid())
                .comCode(userDto.getComCode())
                .userName(userDto.getNickname())
                .userType(UserType.getUserType(userDto.getUserType()))
                .build();
    }
}