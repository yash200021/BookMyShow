package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.request.LoginRequestDto;
import com.example.bookmyshow.dtos.request.UserSignUpRequestDto;
import com.example.bookmyshow.dtos.response.ResponseStatus;
import com.example.bookmyshow.dtos.response.UserSignUpResponseDto;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public UserSignUpResponseDto signup(@RequestBody UserSignUpRequestDto userSignUpRequestDto) {
        User user = userService.signup(userSignUpRequestDto.getName(),
                userSignUpRequestDto.getEmail(),
                userSignUpRequestDto.getPhoneNumber(),
                userSignUpRequestDto.getPassword());

        UserSignUpResponseDto responseDto = new UserSignUpResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setEmail(user.getEmail());
        responseDto.setStatus(ResponseStatus.SUCCESS);
        return responseDto;
    }

    @GetMapping("/login")
    public ResponseStatus login(@RequestBody LoginRequestDto loginRequestDto) {
        return userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
    }
}
