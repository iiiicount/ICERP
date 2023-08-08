package com.count.icount.auth.service;

import com.count.icount.auth.model.entity.Auth;
import com.count.icount.auth.model.securitymodels.AuthenticatedUser;
import com.count.icount.auth.repository.AuthRepository;
import com.count.icount.company.repository.UserRepository;
import com.count.icount.exception.AuthenticationFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class ICountUserDetailService implements UserDetailsService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, AuthenticationFailedException {
        Auth auth = authRepository.findByUserName(username)
                .orElseThrow(AuthenticationFailedException::new);

        return new User(auth.getUserName(), auth.getPassword(), Collections.emptyList());
    }

    public UserDetails loadUserByComCodeAndUsername(String comCode, String username){
        Auth auth = authRepository.findByComCodeAndUserName(comCode, username)
                .orElseThrow(AuthenticationFailedException::new);
        com.count.icount.company.model.entity.User user = userRepository.findByComCodeAndUserName(comCode, username)
                .orElseThrow(AuthenticationFailedException::new);
        return new AuthenticatedUser(
                auth.getUserName(),
                auth.getPassword(),
                auth.getComCode(),
                user.getUserType(),
                Collections.emptyList()
        );
    }
}
