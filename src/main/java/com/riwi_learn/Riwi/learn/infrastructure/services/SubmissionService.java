package com.riwi_learn.Riwi.learn.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Submission;
import com.riwi_learn.Riwi.learn.domain.repositories.SubmissionRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.ISubmissionService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.SubmissionMapper;
import com.riwi_learn.Riwi.learn.util.exceptions.IdNotFoundException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionService implements ISubmissionService{

    @Autowired
    private SubmissionMapper submissionMapper;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public Page<SubmissionResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public SubmissionResponse getById(String id) {
        Submission submission = this.find(id);

        return this.submissionMapper.entityToResponse(submission);
    }

    @Override
    public SubmissionResponse create(SubmissionCreateRequest entity) {
        Submission submission = submissionMapper.requestToEntity(entity);

        Submission submissionSaved = this.submissionRepository.save(submission);

        return submissionMapper.entityToResponse(submissionSaved);
    }

    @Override
    public SubmissionResponse update(String id, SubmissionUpdateRequest entity) {
        Submission submission = this.find(id);

        Submission submissionUpdate = this.submissionMapper.requestToEntity(entity, submission);

        Submission submissionUpdated = this.submissionRepository.save(submissionUpdate);

        return this.submissionMapper.entityToResponse(submissionUpdated);
    }

    @Override
    public void delete(String id) {
        Submission submission = this.find(id);

        this.submissionRepository.delete(submission);
    }

    public Submission find(String id){
        return this.submissionRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Submission"));
    }
    
}
