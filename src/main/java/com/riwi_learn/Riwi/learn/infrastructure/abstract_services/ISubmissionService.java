package com.riwi_learn.Riwi.learn.infrastructure.abstract_services;

import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionResponse;

public interface ISubmissionService extends IBaseService<SubmissionCreateRequest,SubmissionUpdateRequest, SubmissionResponse, String>{
    
}
