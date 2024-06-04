package com.riwi_learn.Riwi.learn.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionBaseResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Assigment;
import com.riwi_learn.Riwi.learn.domain.repositories.AssigmentRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.IAssigmentService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.AssigmentMapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.SubmissionMapper;
import com.riwi_learn.Riwi.learn.util.exceptions.IdNotFoundException;

@Component
public class AssigmentService implements IAssigmentService {

    @Autowired
    private AssigmentMapper assigmentMapper;

    @Autowired
    private SubmissionMapper submissionMapper;

    @Autowired
    private AssigmentRepository assigmentRepository;

    @Override
    public Page<AssigmentResponse> getAll(int page, int size) {
        if(page<0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.assigmentRepository.findAll(pagination).map(
            assigment -> assigmentMapper.entityToResponse(assigment)
        );
    }

    @Override
    public AssigmentResponse getById(String id) {
        Assigment assigment = this.find(id);

        return this.assigmentMapper.entityToResponse(assigment);
    }

    @Override
    public AssigmentResponse create(AssigmentCreateRequest request) {
        Assigment assigment = this.assigmentMapper.requestToEntity(request);
        assigment.setSubmissions(new ArrayList<>());

        return this.assigmentMapper.entityToResponse(this.assigmentRepository.save(assigment));
    }

    @Override
    public AssigmentResponse update(String id, AssigmentUpdateRequest request) {
        
        Assigment assigment = this.find(id);

        Assigment assigmentUpdate = this.assigmentMapper.requestToEntity(request, assigment);

        return this.assigmentMapper.entityToResponse(this.assigmentRepository.save(assigmentUpdate));
    }

    @Override
    public void delete(String id) {
        Assigment assigment = this.find(id);
        this.assigmentRepository.delete(assigment);
    }

    public List<SubmissionBaseResponse> getAllSubmissions(String id){
        Assigment assigment = this.find(id);

        return assigment.getSubmissions().stream().map(
            (submission) -> this.submissionMapper.entityToBaseResponse(submission)
        ).toList();
    }

    public Assigment find(String id){
        return this.assigmentRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Assigment"));
    }
}
