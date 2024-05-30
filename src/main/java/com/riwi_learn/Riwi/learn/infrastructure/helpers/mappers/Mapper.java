package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentToLessonResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseToUserResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonToCourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserToCourseResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Assigment;
import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;
import com.riwi_learn.Riwi.learn.domain.entitties.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class Mapper {

    //Users
    public UserResponse userToResponse(User entity) {

        UserResponse response = new UserResponse();

        BeanUtils.copyProperties(entity, response);

        //Pasar la lista de cursos y mensajes a dto...
        response.setCourses((entity.getCourses().stream().map(this::courseToUserResponse)).toList());

        return response;
    }

    private CourseToUserResponse courseToUserResponse(Course entity){
        CourseToUserResponse response = new CourseToUserResponse();

        BeanUtils.copyProperties(entity, response);
        response.setLesson(entity.getLesson().stream().map(this::lessonToCourseResponse).toList());

        return response;
    }

    //Courses
    public CourseResponse courseToResponse(Course entity) {
        CourseResponse response = new CourseResponse();

        BeanUtils.copyProperties(entity, response);

        response.setLesson(entity.getLesson().stream().map(
            this::lessonToCourseResponse
        ).toList());

        response.setInstructor(this.userToCourseResponse(entity.getInstructor()));

        return response;
    }

    private LessonToCourseResponse lessonToCourseResponse(Lesson entity){
        LessonToCourseResponse response = new LessonToCourseResponse();

        BeanUtils.copyProperties(entity, response);

        return response;        
    }

    private UserToCourseResponse userToCourseResponse(User user){
        UserToCourseResponse response = new UserToCourseResponse();

        BeanUtils.copyProperties(user, response);

        return response;
    }

    //Lesson
    public LessonResponse lessonToResponse(Lesson entity){
        LessonResponse response = new LessonResponse();

        BeanUtils.copyProperties(entity, response);
        response.setAssigments(entity.getAssigments().stream().map(this::assigmentToLessonResponse).toList());

        return response;
    }

    private AssigmentToLessonResponse assigmentToLessonResponse(Assigment entity){
        AssigmentToLessonResponse response = new AssigmentToLessonResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }
}
