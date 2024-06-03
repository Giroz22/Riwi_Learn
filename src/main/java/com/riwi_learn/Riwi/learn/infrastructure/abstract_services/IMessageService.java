package com.riwi_learn.Riwi.learn.infrastructure.abstract_services;

import java.util.List;

import com.riwi_learn.Riwi.learn.api.dto.request.MessageSendRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageResponse;

public interface IMessageService{
    public MessageResponse send(MessageSendRequest request);
    public List<MessageResponse> getAll(String sender_id, String receiver_id);
}
