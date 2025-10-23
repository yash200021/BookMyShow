package com.example.bookmyshow.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequestDto {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
}
