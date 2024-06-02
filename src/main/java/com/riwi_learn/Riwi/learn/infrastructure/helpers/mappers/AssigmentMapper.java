package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionToAssigmentResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Assigment;
import com.riwi_learn.Riwi.learn.domain.repositories.LessonRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AssigmentMapper implements IMapperBase<Assigment, AssigmentCreateRequest, AssigmentResponse>{

    @Autowired
    private LessonRepository lessonRepository;
        
    @Override
    public AssigmentResponse entityToResponse(Assigment entity){
        AssigmentResponse response = Mapper.sourceToTarget(entity, new AssigmentResponse());

        //Submission to response
        response.setSubmissions(
            entity.getSubmissions().stream().map(
                submission -> Mapper.sourceToTarget(submission, new SubmissionToAssigmentResponse())
            ).toList()
        );

        //Lesson to response
        response.setLesson(
            Mapper.sourceToTarget(entity.getLesson(), new LessonBaseResponse())
        );

        return response;
    }

    @Override
    public Assigment requestToEntity(AssigmentCreateRequest request){
        Assigment assigment = Mapper.sourceToTarget(request, new Assigment());

        //Find the lesson
        assigment.setLesson(
            this.lessonRepository.findById(
                request.getLesson_id()
            ).orElse(null)
        );

        return assigment;
    }

    public Assigment requestToEntity(AssigmentUpdateRequest request, Assigment entity){
        return Mapper.sourceToTarget(request, entity);
    }
}
