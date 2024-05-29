package com.riwi_learn.Riwi.learn.api.dto.request;

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
public class MessageCreateRequest {
    private String content;
    private User sender;
    private User receiver;
    private Course course; 
}
