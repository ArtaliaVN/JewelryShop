package com.example.jewelryshop.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String roles;
    private String password;
}
