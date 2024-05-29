package com.riwi_learn.Riwi.learn.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourseResponse {
    private String id;
    private String name;
    private String description;
    private UserToCourseResponse instructor;
    private List<LessonToCourseResponse> lesson;
}
