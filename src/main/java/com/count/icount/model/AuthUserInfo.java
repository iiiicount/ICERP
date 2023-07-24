package com.count.icount.model;

import com.count.icount.company.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserInfo {
    private String comCode;
    private String userName;
    private String url;

    public static AuthUserInfo convertToUserInfo(User user, HttpServletRequest request){
        return AuthUserInfo.builder()
                .comCode(user.getComCode())
                .userName(user.getUserName())
                .url(request.getRequestURI())
                .build();
    }
}
