package com.riwi_learn.Riwi.learn.api.dto.response;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AssigmentBaseResponse {
    private String id;
    private String title;
    private String description;
    private LocalDate due_date;
    private List<SubmissionToAssigmentResponse> submissions;
}
