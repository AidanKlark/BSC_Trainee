package com.example.todo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class AccountDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String role;
}
