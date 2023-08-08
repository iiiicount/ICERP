package com.count.icount.company.service;


import com.count.icount.company.model.entity.User;
import com.count.icount.company.model.dto.UserDto;
import com.count.icount.company.repository.UserRepository;
import com.count.icount.exception.AuthenticationFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private boolean checkDuplicatedUser(User user){
        return userRepository.findByComCodeAndUserName(user.getComCode(), user.getUserName()).isPresent();
    }

    public UserDto getUserById(String comCode, String Uid){
        Optional<User> user = userRepository.findByComCodeAndUid(comCode, Uid);
        return user.map(UserDto::Of).orElse(null);
    }

    public UserDto getUserByComCodeAndNickName(String comCode, String nickname){
        Optional<User> user = userRepository.findByComCodeAndUserName(comCode, nickname);
        return user.map(UserDto::Of).orElse(null);
    }

    @Transactional
    public UserDto saveUser(UserDto userInfo){
        User newUser = User.of((userInfo));

        if(checkDuplicatedUser(newUser)){
            throw new AuthenticationFailedException("user already exist");
        }

        return UserDto.Of(userRepository.save(newUser));
    }

    public boolean checkNickname(String comCode, String nickname){
        User user = userRepository.findByComCodeAndUserName(comCode, nickname).orElse(null);
        return user == null;
    }

}
