package com.riwi_learn.Riwi.learn.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LessonUpdateRequest {
    private String lesson_title;
    private String content;
}
