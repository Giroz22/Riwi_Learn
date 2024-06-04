package com.riwi_learn.Riwi.learn.infrastructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi_learn.Riwi.learn.api.dto.request.MessageSendRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Message;
import com.riwi_learn.Riwi.learn.domain.repositories.MessageRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.IMessageService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.MessageMapper;
import com.riwi_learn.Riwi.learn.util.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MessageService implements IMessageService{

    @Autowired
    private final MessageRepository messageRepository;

    @Autowired
    private final MessageMapper messageMapper;

    @Override
    public MessageResponse send(MessageSendRequest request) {
        Message messageSend = this.messageMapper.requestToEntity(request);

        return this.messageMapper.entityToResponse(this.messageRepository.save(messageSend));
    }

    @Override
    public List<MessageResponse> getAll(String sender_id, String receiver_id) {

        List<Message> listMessage = this.messageRepository.findAllMessages(sender_id, receiver_id);

        return listMessage.stream().map(
            (message) -> this.messageMapper.entityToResponse(message)
        ).toList();        
    }
      
    public Message find(String id){
        return this.messageRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Message"));
    }
}
