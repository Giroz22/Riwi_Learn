package com.riwi_learn.Riwi.learn.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MessageBaseResponse { 
    private String id;
    private String content;
    private LocalDate sent_date;
    private UserBaseResponse sender;
    private UserBaseResponse receiver;
}
