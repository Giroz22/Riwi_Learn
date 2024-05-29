package com.riwi_learn.Riwi.learn.infrastructure.abstract_services;

import com.riwi_learn.Riwi.learn.api.dto.request.MessageCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.MessageUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageResponse;

public interface IMessageService extends IBaseService<MessageCreateRequest, MessageUpdateRequest, MessageResponse, String>{
    
}
