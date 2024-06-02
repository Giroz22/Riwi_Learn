package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Submission;

public class SubmissionMapper implements IMapperBase<Submission, SubmissionCreateRequest, SubmissionResponse>{    
    @Override
    public Submission requestToEntity(SubmissionCreateRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestToEntity'");
    }
    
    public Submission requestToEntity(SubmissionUpdateRequest request, Submission entity){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entityToResponse'");
    }

    @Override
    public SubmissionResponse entityToResponse(Submission entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'entityToResponse'");
    }
}
