package com.riwi_learn.Riwi.learn.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi_learn.Riwi.learn.api.dto.request.LessonCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.LessonUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonResponse;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.ILessonService;

public class LessonService implements ILessonService{

    @Override
    public Page<LessonResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public LessonResponse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public LessonResponse create(LessonCreateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public LessonResponse update(String id, LessonUpdateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
