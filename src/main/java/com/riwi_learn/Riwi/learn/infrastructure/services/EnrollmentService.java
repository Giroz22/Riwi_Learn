package com.riwi_learn.Riwi.learn.infrastructure.services;

import org.springframework.data.domain.Page;

import com.riwi_learn.Riwi.learn.api.dto.request.EnrollmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.EnrollmentUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.EnrollmentResponse;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.IEnrollmentService;

public class EnrollmentService implements IEnrollmentService{

    @Override
    public Page<EnrollmentResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public EnrollmentResponse getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public EnrollmentResponse create(EnrollmentCreateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public EnrollmentResponse update(String id, EnrollmentUpdateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
