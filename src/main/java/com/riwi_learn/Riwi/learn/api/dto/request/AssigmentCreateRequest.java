package com.riwi_learn.Riwi.learn.api.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AssigmentCreateRequest {
    private String title;
    private String description;
    private LocalDate due_date;
}
