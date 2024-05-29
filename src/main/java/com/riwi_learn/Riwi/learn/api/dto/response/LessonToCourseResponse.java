package com.riwi_learn.Riwi.learn.api.dto.response;

import java.util.List;

import com.riwi_learn.Riwi.learn.domain.entitties.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LessonToCourseResponse {
    private String id;
    private String title;
    private String content;
    private Course course;
    private List<AssigmentResponse> assigments;
}
