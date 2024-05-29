package com.riwi_learn.Riwi.learn.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionResponse;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.ISubmissionService;

public class SubmissionService implements ISubmissionService{

    @Override
    public Page<SubmissionResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public SubmissionResponse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public SubmissionResponse create(SubmissionCreateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public SubmissionResponse update(String id, SubmissionUpdateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
