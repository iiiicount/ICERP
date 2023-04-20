package com.count.icount.company.controller;

import com.count.icount.auth.repository.AuthRepository;
import com.count.icount.auth.service.AuthService;
import com.count.icount.company.Model.dto.JoinUserRequestDto;
import com.count.icount.company.Model.dto.UserDto;
import com.count.icount.company.repository.UserRepository;
import com.count.icount.company.service.UserService;
import com.count.icount.model.Dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping
    public Response<UserDto> saveUser(@RequestBody JoinUserRequestDto userInfo){
        authService.saveAuth(userInfo.getUserName(), userInfo.getComCode(), userInfo.getPassword());
        UserDto newUserInfo = userService.saveUser(new UserDto(
                userInfo.getComCode(),
                null,
                null,
                userInfo.getUserName(),
                "NORMAL"
        ));
        return new Response<>(newUserInfo);
    }

}
