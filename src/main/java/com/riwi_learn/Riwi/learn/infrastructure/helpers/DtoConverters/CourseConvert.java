package com.riwi_learn.Riwi.learn.infrastructure.helpers.DtoConverters;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.CourseUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.CourseCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonToCourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserToCourseResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;
import com.riwi_learn.Riwi.learn.domain.entitties.User;
import com.riwi_learn.Riwi.learn.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CourseConvert  {

    @Autowired
    private UserRepository userRepository;

    public Course requestCreateToEntity(CourseCreateRequest request, Course entity) {
        
        BeanUtils.copyProperties(request, entity);

        entity.setInstructor(this.userRepository.findById(request.getInstructor_id()).orElse(null));

        return entity;
    }

    public Course requestUpdateToEntity(CourseUpdateRequest request, Course entity) {
        
        BeanUtils.copyProperties(request, entity);

        return entity;
    }

    public CourseResponse EntityToResponse(Course entity) {
        CourseResponse response = new CourseResponse();

        BeanUtils.copyProperties(entity, response);

        response.setLesson(entity.getLesson().stream().map(
            this::lessonToLessonResponse
        ).toList());

        response.setInstructor(this.userToCourseResponse(entity.getInstructor()));

        return response;
    }

    private LessonToCourseResponse lessonToLessonResponse(Lesson entity){
        LessonToCourseResponse response = new LessonToCourseResponse();

        BeanUtils.copyProperties(entity, response);

        return response;        
    }

    private UserToCourseResponse userToCourseResponse(User user){
        UserToCourseResponse response = new UserToCourseResponse();

        BeanUtils.copyProperties(user, response);

        return response;
    }
    
}
