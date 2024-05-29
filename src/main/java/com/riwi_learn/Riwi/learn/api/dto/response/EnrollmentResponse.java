package com.riwi_learn.Riwi.learn.api.dto.response;

import java.time.LocalDate;

import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.entitties.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnrollmentResponse {
    private String id;
    private User user;
    private Course course;
    private LocalDate date_enrollment;
}
