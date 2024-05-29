package com.riwi_learn.Riwi.learn.api.dto.request;

import com.riwi_learn.Riwi.learn.util.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCreateRequest{
    private String username;
    private String password;
    private String email;
    private String full_name;
    private UserRole role;
}
