package com.count.icount.annotation;

import com.count.icount.auth.model.securityModels.ICountAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    public static AuthUserInfo convertToUserInfo(ICountAuthentication authentication, HttpServletRequest request){
        return AuthUserInfo.builder()
                .comCode(authentication.getComCode())
                .userName(authentication.getName())
                .url(request.getRequestURI())
                .build();
    }
}
