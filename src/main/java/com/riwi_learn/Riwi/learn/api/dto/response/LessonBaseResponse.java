package com.riwi_learn.Riwi.learn.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LessonBaseResponse {
    private String id;
    private String title;
    private String content;
}
