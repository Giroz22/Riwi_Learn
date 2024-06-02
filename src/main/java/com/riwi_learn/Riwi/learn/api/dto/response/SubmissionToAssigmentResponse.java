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
public class SubmissionToAssigmentResponse {
    private String id;
    private String content;
    private LocalDate date;
    private double grade;
    private UserBaseResponse user;
}
