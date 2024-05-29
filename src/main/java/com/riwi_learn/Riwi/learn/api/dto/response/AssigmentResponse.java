package com.riwi_learn.Riwi.learn.api.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AssigmentResponse {
    private String id;
    private String title;
    private String description;
    private LocalDate due_date;
    private Lesson lesson;
    private List<SubmissionResponse> submissions;
}
