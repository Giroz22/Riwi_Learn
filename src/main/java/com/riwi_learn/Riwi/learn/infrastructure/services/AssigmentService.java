package com.riwi_learn.Riwi.learn.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentResponse;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.IAssigmentService;

public class AssigmentService implements IAssigmentService {

    @Override
    public Page<AssigmentResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public AssigmentResponse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public AssigmentResponse create(AssigmentCreateRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public AssigmentResponse update(String id, AssigmentUpdateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
