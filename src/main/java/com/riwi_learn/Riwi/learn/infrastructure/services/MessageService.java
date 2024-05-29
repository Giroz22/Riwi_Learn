package com.riwi_learn.Riwi.learn.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi_learn.Riwi.learn.api.dto.request.MessageCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.MessageUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageResponse;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.IMessageService;

public class MessageService implements IMessageService{

    @Override
    public Page<MessageResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public MessageResponse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public MessageResponse create(MessageCreateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public MessageResponse update(String id, MessageUpdateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
