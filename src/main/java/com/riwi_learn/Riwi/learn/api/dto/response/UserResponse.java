package com.riwi_learn.Riwi.learn.api.dto.response;

import java.util.List;

import com.riwi_learn.Riwi.learn.util.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private String full_name;
    private UserRole role;
    private List<CourseToUserResponse> courses;
}
