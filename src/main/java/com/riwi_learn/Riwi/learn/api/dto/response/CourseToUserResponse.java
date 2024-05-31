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
public class CourseToUserResponse {
    private String id;
    private String name;
    private String description;
    private List<LessonResponse> lessons;
}
