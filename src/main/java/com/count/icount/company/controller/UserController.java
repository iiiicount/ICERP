package com.count.icount.company.controller;

import com.count.icount.annotation.AuthInfo;
import com.count.icount.model.AuthUserInfo;
import com.count.icount.auth.service.AuthService;
import com.count.icount.company.Model.dto.AddUserRequestDto;
import com.count.icount.company.Model.dto.CheckNicknameResponseDto;
import com.count.icount.company.Model.dto.UserDto;
import com.count.icount.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody AddUserRequestDto userInfo){
        authService.saveAuth(userInfo.getUserName(), userInfo.getComCode(), userInfo.getPassword());
        UserDto newUserInfo = userService.saveUser(new UserDto(
                userInfo.getComCode(),
                null,
                null,
                userInfo.getUserName(),
                "NORMAL"
        ));
        return new ResponseEntity<>(newUserInfo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> methodArgResolverTest(@AuthInfo AuthUserInfo authUserInfo){
        return new ResponseEntity<>("com_code: " + authUserInfo.getComCode() + " user_name: " + authUserInfo.getUserName(), HttpStatus.OK);
    }

    @GetMapping("check-nickname")
    public ResponseEntity<?> checkNickname(
            @AuthInfo AuthUserInfo authUserInfo,
            @RequestParam(name = "nickname") String nickname){
        boolean success = userService.checkNickname(authUserInfo.getComCode(), nickname);
        return new ResponseEntity<>(
                CheckNicknameResponseDto.builder()
                        .comCode(authUserInfo.getComCode())
                        .nickname(nickname)
                        .success(success)
                        .build(),
                HttpStatus.OK
        );
    }


}
