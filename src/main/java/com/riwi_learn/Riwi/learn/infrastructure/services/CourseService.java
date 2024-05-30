package com.riwi_learn.Riwi.learn.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi_learn.Riwi.learn.api.dto.request.CourseCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.CourseUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.repositories.CourseRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.ICourseService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.CourseMapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.Mapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private Mapper mapper;

    @Autowired
    private CourseMapper courseConvert;

    @Override
    public Page<CourseResponse> getAll(int page, int size) {
        if(page < 0 ) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return courseRepository.findAll(pagination).map(course ->  this.mapper.courseToResponse(course));
    }

    @Override
    public CourseResponse getById(String id) {
        Course course = this.courseRepository.findById(id).orElse(null);

        return this.mapper.courseToResponse(course);
    }

    @Override
    public CourseResponse create(CourseCreateRequest request) {
        Course course = this.courseConvert.requestCreateToEntity(request, new Course());

        course.setLesson(new ArrayList<>());
        course.setMessages(new ArrayList<>());
        
        Course courseSaved = this.courseRepository.save(course);

        return this.mapper.courseToResponse(courseSaved);
    }

    @Override
    public CourseResponse update(String id, CourseUpdateRequest request) {
        Course course = this.courseRepository.findById(id).orElse(null);

        Course courseUpdate = this.courseConvert.requestUpdateToEntity(request, course);

        Course courseUpdated = this.courseRepository.save(courseUpdate);

        return this.mapper.courseToResponse(courseUpdated);
    }

    @Override
    public void delete(String id) {
        Course courseDelete = this.courseRepository.findById(id).orElse(null);

        this.courseRepository.delete(courseDelete);
    }

}
