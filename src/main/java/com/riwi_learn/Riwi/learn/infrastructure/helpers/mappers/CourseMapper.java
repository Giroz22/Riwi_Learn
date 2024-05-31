package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.CourseUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonToCourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserToCourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.request.CourseCreateRequest;
import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CourseMapper  {

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
    
    public CourseResponse courseToResponse(Course entity) {
        CourseResponse response =  new CourseResponse();

        BeanUtils.copyProperties(entity, response);

        response.setLesson(entity.getLesson().stream().map(
            (lesson)-> Mapper.sourceToTarget(lesson, new LessonToCourseResponse())
        ).toList());

        response.setInstructor(Mapper.sourceToTarget(entity.getInstructor(), new UserToCourseResponse()));

        return response;
    }
}
