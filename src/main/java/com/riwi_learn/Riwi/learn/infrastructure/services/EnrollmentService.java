package com.riwi_learn.Riwi.learn.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.EnrollmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.EnrollmentUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.EnrollmentResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Enrollment;
import com.riwi_learn.Riwi.learn.domain.repositories.EnrollmentRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.IEnrollmentService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.EnrollmentMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentService implements IEnrollmentService{

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Override
    public Page<EnrollmentResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public EnrollmentResponse getById(String id) {
        Enrollment entity = this.enrollmentRepository.findById(id).orElse(null);
        
        return this.enrollmentMapper.entityToResponse(entity);
    }

    @Override
    public EnrollmentResponse create(EnrollmentCreateRequest request) {
        Enrollment entity = this.enrollmentMapper.requestToEntity(request);

        Enrollment entitySaved = this.enrollmentRepository.save(entity);

        return this.enrollmentMapper.entityToResponse(entitySaved);
    }

    @Override
    public EnrollmentResponse update(String id, EnrollmentUpdateRequest entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        Enrollment entity = this.enrollmentRepository.findById(id).orElse(null);

        this.enrollmentRepository.delete(entity);
    }    
}
