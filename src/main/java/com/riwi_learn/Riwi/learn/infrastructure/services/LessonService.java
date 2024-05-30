package com.riwi_learn.Riwi.learn.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi_learn.Riwi.learn.api.dto.request.LessonCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.LessonUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;
import com.riwi_learn.Riwi.learn.domain.repositories.LessonRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.ILessonService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.LessonMapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.Mapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService{

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    Mapper mapper;

    @Autowired
    LessonMapper lessonMapper;

    @Override
    public Page<LessonResponse> getAll(int page, int size) {
        if(page < 0) page =  0;
        PageRequest pagination = PageRequest.of(page, size);
        

        return this.lessonRepository.findAll(pagination).map((Lesson lesson) -> this.mapper.lessonToResponse(lesson));
    }

    @Override
    public LessonResponse getById(String id) {
        Lesson lesson = this.lessonRepository.findById(id).orElse(null);

        return this.mapper.lessonToResponse(lesson);
    }

    @Override
    public LessonResponse create(LessonCreateRequest request) {

        Lesson lesson = this.lessonMapper.requestCreateToEntity(request, new Lesson());

        Lesson newLesson = this.lessonRepository.save(lesson);

        return this.mapper.lessonToResponse(newLesson);
    }

    @Override
    public LessonResponse update(String id, LessonUpdateRequest request) {
        Lesson lesson = this.lessonRepository.findById(id).orElse(null);
        
        Lesson lessonUpdate = this.lessonMapper.requestUpdateToEntity(request,lesson);

        Lesson lessonUpdated = this.lessonRepository.save(lessonUpdate);

        return this.mapper.lessonToResponse(lessonUpdated);
    }

    @Override
    public void delete(String id) {
        Lesson lesson = this.lessonRepository.findById(id).orElse(null);

        this.lessonRepository.delete(lesson);
        return;
    }
    
}
