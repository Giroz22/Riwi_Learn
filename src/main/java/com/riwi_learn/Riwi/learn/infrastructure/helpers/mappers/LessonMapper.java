package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.LessonCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.LessonUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentToLessonResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionToAssigmentResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserBaseResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;
import com.riwi_learn.Riwi.learn.domain.entitties.Submission;
import com.riwi_learn.Riwi.learn.domain.repositories.CourseRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class LessonMapper implements IMapperBase<Lesson, LessonCreateRequest, LessonResponse>{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Lesson requestToEntity(LessonCreateRequest request){
        Lesson entity = Mapper.sourceToTarget(request, new Lesson());

        entity.setCourse(this.courseRepository.findById(request.getCourse_id()).orElse(null));

        return entity;
    }

    public Lesson requestToEntity(LessonUpdateRequest request, Lesson entity){
        BeanUtils.copyProperties(request, entity);

        return entity;
    }

    @Override   
    public LessonResponse entityToResponse(Lesson entity){
        SubmissionMapper submissionMapper = new SubmissionMapper();

        LessonResponse response = Mapper.sourceToTarget(entity, new LessonResponse());

        response.setAssigments(entity.getAssigments().stream().map(
            (assigment)-> Mapper.sourceToTarget(assigment, 
                AssigmentToLessonResponse.builder()
                .submissions(
                    assigment.getSubmissions().stream().map(
                        (submission)-> submissionMapper.entityToResponse(submission)
                    ).toList()
                )
                .build()
            )
        ).toList());

        //Find and transfor the info of instructor to its dto response
        UserBaseResponse instructor = Mapper.sourceToTarget(
            entity.getCourse().getInstructor(), new UserBaseResponse()
        );
    
        response.setCourse(
            Mapper.sourceToTarget(
                entity.getCourse(), CourseBaseResponse.builder().instructor(instructor).build()
            )
        );

        return response;
    }

    public LessonBaseResponse entityToBaseResponse(Lesson entity){
        return Mapper.sourceToTarget(entity, new LessonBaseResponse());
    }

    public SubmissionToAssigmentResponse submissionToAssigmentResponse(Submission submission){
        return Mapper.sourceToTarget(submission, new SubmissionToAssigmentResponse());
    }
}
