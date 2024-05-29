package com.riwi_learn.Riwi.learn.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserUpdateRequest {
    private String username;
    private String password;
    private String email;
    private String full_name;
}
