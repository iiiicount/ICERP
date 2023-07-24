package com.count.icount.auth.service;

import com.count.icount.auth.model.entity.Auth;
import com.count.icount.auth.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public Auth saveAuth(String name, String comCode, String password){
        Auth auth = new Auth(name, comCode, passwordEncoder.encode(password));
        return authRepository.save(auth);
    }

}
