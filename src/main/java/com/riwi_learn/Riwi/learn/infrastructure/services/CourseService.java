package com.riwi_learn.Riwi.learn.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi_learn.Riwi.learn.api.dto.request.CourseCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.CourseUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserBaseResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.entitties.Enrollment;
import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;
import com.riwi_learn.Riwi.learn.domain.repositories.CourseRepository;
import com.riwi_learn.Riwi.learn.domain.repositories.EnrollmentRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.ICourseService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.CourseMapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.MessageMapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.UserMapper;
import com.riwi_learn.Riwi.learn.util.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private final MessageMapper messageMapper;

    @Override
    public Page<CourseResponse> getAll(int page, int size) {
        if(page < 0 ) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return courseRepository.findAll(pagination).map(course ->  this.courseMapper.entityToResponse(course));
    }

    @Override
    public CourseResponse getById(String id) {
        Course course = this.find(id);

        return this.courseMapper.entityToResponse(course);
    }

    @Override
    public CourseResponse create(CourseCreateRequest request) {
        Course course = this.courseMapper.requestToEntity(request);

        course.setLesson(new ArrayList<>());
        course.setMessages(new ArrayList<>());
        
        Course courseSaved = this.courseRepository.save(course);

        return this.courseMapper.entityToResponse(courseSaved);
    }

    @Override
    public CourseResponse update(String id, CourseUpdateRequest request) {
        Course course = this.find(id);

        Course courseUpdate = this.courseMapper.requestToEntity(request, course);

        Course courseUpdated = this.courseRepository.save(courseUpdate);

        return this.courseMapper.entityToResponse(courseUpdated);
    }

    @Override
    public void delete(String id) {
        Course courseDelete = this.find(id);

        this.courseRepository.delete(courseDelete);
    }

    public List<LessonBaseResponse> getLessons(String id){

        List<Lesson> lessons = this.courseRepository.findById(id).orElse(null).getLesson();

        return this.courseMapper.listLessonToResponse(lessons);
    }

    public List<UserBaseResponse> getAllUsersInCourse(String id){
        Course course = this.find(id);
        List<Enrollment> enrollments = this.enrollmentRepository.findUsersByCourse(course);

        return enrollments.stream().map(
            enrollment -> this.userMapper.entityToBaseResponse(enrollment.getUser())
        ).toList();
    }

    public List<MessageBaseResponse> getAllMessages(String id){
        Course course = this.find(id);

        return course.getMessages().stream().map(
            (message)-> messageMapper.entityToBaseResponse(message)
        ).toList();
    }

    public Course find(String id){
        return this.courseRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Course"));
    }
}
