package com.example.bookmyshow.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpResponseDto {
    private Long id;
    private String name;
    private String email;
    private ResponseStatus status;
}
