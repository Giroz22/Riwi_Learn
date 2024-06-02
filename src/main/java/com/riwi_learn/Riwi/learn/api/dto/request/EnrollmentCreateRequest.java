package com.riwi_learn.Riwi.learn.api.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnrollmentCreateRequest {
    private String user_id;
    private String course_id;
    private LocalDate date_enrollment;
}
