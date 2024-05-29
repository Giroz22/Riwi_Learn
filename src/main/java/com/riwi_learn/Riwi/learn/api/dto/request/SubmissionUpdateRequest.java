package com.riwi_learn.Riwi.learn.api.dto.request;

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
public class SubmissionUpdateRequest {
    private String content;
    private double grade;
    private User user;
    private Assigment assigment;
}
