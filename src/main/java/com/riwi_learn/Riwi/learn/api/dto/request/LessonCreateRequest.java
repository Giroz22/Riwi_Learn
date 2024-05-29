package com.riwi_learn.Riwi.learn.api.dto.request;

import com.riwi_learn.Riwi.learn.domain.entitties.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LessonCreateRequest {
    private String title;
    private String content;
    private Course course;
}
