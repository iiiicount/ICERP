package com.count.icount.company.Model.Entity;

import com.count.icount.company.Model.Entity.PK.UserPK;
import com.count.icount.company.Model.dto.UserDto;
import com.count.icount.company.Model.enums.UserType;
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