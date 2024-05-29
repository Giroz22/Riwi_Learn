package com.riwi_learn.Riwi.learn.api.dto.response;

import java.time.LocalDate;

import com.riwi_learn.Riwi.learn.domain.entitties.Assigment;
import com.riwi_learn.Riwi.learn.domain.entitties.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SubmissionResponse {
    private String id;
    private String content;
    private LocalDate date;
    private double grade;
    private User user;
    private Assigment assigment;
}
