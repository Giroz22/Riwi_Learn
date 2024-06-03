package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.MessageSendRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserBaseResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Message;
import com.riwi_learn.Riwi.learn.domain.repositories.CourseRepository;
import com.riwi_learn.Riwi.learn.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MessageMapper implements IMapperBase<Message, MessageSendRequest, MessageResponse>{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final CourseMapper courseMapper;

    @Override
    public Message requestToEntity(MessageSendRequest request) {
        return Message.builder()
        .sender(this.userRepository.findById(request.getSender_id()).orElse(null))
        .receiver(this.userRepository.findById(request.getReceiver_id()).orElse(null))
        .course(this.courseRepository.findById(request.getCourse_id()).orElse(null))
        .content(request.getContent())
        .sent_date(LocalDate.now())
        .build();
    }

    @Override
    public MessageResponse entityToResponse(Message entity) {
        return MessageResponse.builder()
        .id(entity.getId())
        .content(entity.getContent())
        .sent_date(entity.getSent_date())
        .sender(Mapper.sourceToTarget(entity.getSender(), new UserBaseResponse()))
        .receiver(Mapper.sourceToTarget(entity.getReceiver(), new UserBaseResponse()))
        .course(courseMapper.entityToBaseResponse(entity.getCourse()))
        .build();
    }

    public MessageBaseResponse entityToBaseResponse(Message entity) {
        return MessageBaseResponse.builder()
        .id(entity.getId())
        .content(entity.getContent())
        .sent_date(entity.getSent_date())
        .sender(Mapper.sourceToTarget(entity.getSender(), new UserBaseResponse()))
        .receiver(Mapper.sourceToTarget(entity.getReceiver(), new UserBaseResponse()))
        .build();
    }
    
}
