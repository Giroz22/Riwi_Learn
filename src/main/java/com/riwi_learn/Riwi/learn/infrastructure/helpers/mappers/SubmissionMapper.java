package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentToSubmissionResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Submission;
import com.riwi_learn.Riwi.learn.domain.repositories.AssigmentRepository;
import com.riwi_learn.Riwi.learn.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionMapper implements IMapperBase<Submission, SubmissionCreateRequest, SubmissionResponse>{   
    
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssigmentRepository assigmentRepository;
    
    @Override
    public Submission requestToEntity(SubmissionCreateRequest request) {
        Submission entity = Submission.builder()
                            .content(request.getContent())
                            .date(LocalDate.now())
                            .user(userRepository.findById(request.getUser_id()).orElse(null))
                            .assigment(assigmentRepository.findById(request.getAssigment_id()).orElse(null))
                            .build();
        return entity;
    }
    
    public Submission requestToEntity(SubmissionUpdateRequest request, Submission entity){
        return Mapper.sourceToTarget(request, entity);
    }

    @Override
    public SubmissionResponse entityToResponse(Submission entity) {
        SubmissionResponse response = Mapper.sourceToTarget(entity, new SubmissionResponse());

        response.setUser(userMapper.entityToBaseResponse(entity.getUser()));
        response.setAssigment(
            Mapper.sourceToTarget(
                entity.getAssigment(), 
                AssigmentToSubmissionResponse.builder()
                .lesson(this.lessonMapper.entityToBaseResponse(entity.getAssigment().getLesson()))
                .build()
            )
        );

        return response;
    }

    public SubmissionBaseResponse entityToBaseResponse(Submission entity){
        
        SubmissionBaseResponse response = Mapper.sourceToTarget(entity, new SubmissionBaseResponse());

        response.setUser(userMapper.entityToBaseResponse(entity.getUser()));

        return response;
    }
}
