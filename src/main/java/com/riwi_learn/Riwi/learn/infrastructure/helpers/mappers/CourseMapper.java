package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.CourseUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonToCourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserToCourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.request.CourseCreateRequest;
import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;
import com.riwi_learn.Riwi.learn.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CourseMapper implements IMapperBase<Course, CourseCreateRequest, CourseResponse> {

    @Autowired
    LessonMapper lessonMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Course requestToEntity(CourseCreateRequest request) {
        
        Course entity = Mapper.sourceToTarget(request, new Course());

        entity.setInstructor(this.userRepository.findById(request.getInstructor_id()).orElse(null));

        return entity;
    }

    public Course requestToEntity(CourseUpdateRequest request, Course entity) {
        
        BeanUtils.copyProperties(request, entity);

        return entity;
    }

    @Override
    public CourseResponse entityToResponse(Course entity) {

        CourseResponse response =  new CourseResponse();

        BeanUtils.copyProperties(entity, response);

        response.setLesson(entity.getLesson().stream().map(
            (lesson)-> Mapper.sourceToTarget(
                lesson, LessonToCourseResponse.builder()
                .assigments(null)//change null for the function assigmentsToResponse of assigmentMapper
                .build()
            )
        ).toList());

        response.setInstructor(Mapper.sourceToTarget(entity.getInstructor(), new UserToCourseResponse()));

        return response;
    }

    public List<LessonBaseResponse> listLessonToResponse(List<Lesson> lessons){
        
        List<LessonBaseResponse> lessonsResponse = lessons.stream().map(
            lesson -> Mapper.sourceToTarget( lesson, new LessonBaseResponse() )
        ).toList();

        return lessonsResponse;
    }
}
