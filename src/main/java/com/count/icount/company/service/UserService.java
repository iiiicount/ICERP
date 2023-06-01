package com.count.icount.company.service;


import com.count.icount.company.Model.Entity.User;
import com.count.icount.company.Model.dto.UserDto;
import com.count.icount.company.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getUserById(String comCode, String Uid){
        Optional<User> user = userRepository.findByComCodeAndUid(comCode, Uid);
        return user.map(UserDto::Of).orElse(null);
    }

    public UserDto getUserByComCodeAndNickName(String comCode, String nickname){
        Optional<User> user = userRepository.findByComCodeAndUserName(comCode, nickname);
        return user.map(UserDto::Of).orElse(null);
    }

    public UserDto saveUser(UserDto userInfo){
        User newUser = User.of((userInfo));
        return UserDto.Of(userRepository.save(newUser));
    }

    public boolean checkNickname(String comCode, String nickname){
        User user = userRepository.findByComCodeAndUserName(comCode, nickname).orElse(null);
        return user == null;
    }

}
