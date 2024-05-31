package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.LessonCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.LessonUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentToLessonResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseToLessonResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserBasicResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;
import com.riwi_learn.Riwi.learn.domain.repositories.CourseRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LessonMapper {

    @Autowired
    CourseRepository courseRepository;

    public Lesson requestCreateToEntity(LessonCreateRequest request, Lesson entity){
        BeanUtils.copyProperties(request, entity);

        entity.setCourse(this.courseRepository.findById(request.getCourse_id()).orElse(null));

        return entity;
    }

    public Lesson requestUpdateToEntity(LessonUpdateRequest request, Lesson entity){
        BeanUtils.copyProperties(request, entity);

        return entity;
    }

    public LessonResponse lessonToResponse(Lesson entity){
        LessonResponse response = Mapper.sourceToTarget(entity, new LessonResponse());

        response.setAssigments(entity.getAssigments().stream().map((assigment)-> Mapper.sourceToTarget(assigment, new AssigmentToLessonResponse())).toList());

        //Find and transfor the info of instructor to its dto response
        UserBasicResponse instructor = Mapper.sourceToTarget(
            entity.getCourse().getInstructor(), new UserBasicResponse()
        );
    
        response.setCourse(
            Mapper.sourceToTarget(
                entity.getCourse(),CourseToLessonResponse.builder().instructor(instructor).build()
            )
        );

        return response;
    }
}
