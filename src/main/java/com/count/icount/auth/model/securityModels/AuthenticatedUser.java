package com.count.icount.auth.model.securityModels;

import com.count.icount.company.Model.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class AuthenticatedUser extends User {
    private String comCode;
    private UserType userType;
    public AuthenticatedUser(String username, String password, String comCode, UserType userType, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.comCode = comCode;
        this.userType = userType;
    }
}
