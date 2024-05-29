package com.riwi_learn.Riwi.learn.api.dto.response;

import java.time.LocalDate;

import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.entitties.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MessageResponse { 
    private String id;
    private String content;
    private LocalDate sent_date;
    private User sender;
    private User receiver;
    private Course course; 
}
