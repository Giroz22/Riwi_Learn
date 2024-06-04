package com.riwi_learn.Riwi.learn.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi_learn.Riwi.learn.api.dto.request.LessonCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.LessonUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Assigment;
import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;
import com.riwi_learn.Riwi.learn.domain.repositories.LessonRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.ILessonService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.AssigmentMapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.LessonMapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.Mapper;
import com.riwi_learn.Riwi.learn.util.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService{

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    LessonMapper lessonMapper;

    @Autowired
    AssigmentMapper assigmentMapper;

    @Override
    public Page<LessonResponse> getAll(int page, int size) {
        if(page < 0) page =  0;
        PageRequest pagination = PageRequest.of(page, size);
        

        return this.lessonRepository.findAll(pagination).map((Lesson lesson) -> this.lessonMapper.entityToResponse(lesson));
    }

    @Override
    public LessonResponse getById(String id) {
        Lesson lesson = this.find(id);

        return this.lessonMapper.entityToResponse(lesson);
    }

    @Override
    public LessonResponse create(LessonCreateRequest request) {

        Lesson lesson = this.lessonMapper.requestToEntity(request);
        lesson.setAssigments(new ArrayList<Assigment>());

        Lesson newLesson = this.lessonRepository.save(lesson);

        return this.lessonMapper.entityToResponse(newLesson);
    }

    @Override
    public LessonResponse update(String id, LessonUpdateRequest request) {
        Lesson lesson = this.find(id);
        
        Lesson lessonUpdate = this.lessonMapper.requestToEntity(request,lesson);

        Lesson lessonUpdated = this.lessonRepository.save(lessonUpdate);

        return this.lessonMapper.entityToResponse(lessonUpdated);
    }

    @Override
    public void delete(String id) {
        Lesson lesson = this.find(id);

        this.lessonRepository.delete(lesson);
        return;
    }

    public List<AssigmentBaseResponse> getAllAssigments(String id){
        Lesson lesson = this.find(id);

        return lesson.getAssigments().stream().map(
            (Assigment assigment) -> Mapper.sourceToTarget(
                assigment, 
                AssigmentBaseResponse.builder()
                .submissions(
                    assigment.getSubmissions().stream().map(
                        (submission) -> lessonMapper.submissionToAssigmentResponse(submission)
                    ).toList()
                )
                .build()
            )
        ) .toList();
    }
   
    public Lesson find(String id){
        return this.lessonRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Lesson"));
    }
}
