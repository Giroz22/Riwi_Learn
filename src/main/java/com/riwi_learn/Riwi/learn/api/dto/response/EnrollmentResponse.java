package com.riwi_learn.Riwi.learn.api.dto.response;

import java.time.LocalDate;

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
    private UserBaseResponse user;
    private CourseBaseResponse course;
    private LocalDate date_enrollment;    
}

