package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.LessonCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.LessonUpdateRequest;
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
}
