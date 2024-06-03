package com.riwi_learn.Riwi.learn.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MessageSendRequest {
    private String content;
    private String sender_id;
    private String receiver_id;
    private String course_id; 
}
