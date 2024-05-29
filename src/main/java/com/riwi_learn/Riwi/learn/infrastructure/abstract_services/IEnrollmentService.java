package com.riwi_learn.Riwi.learn.infrastructure.abstract_services;

import com.riwi_learn.Riwi.learn.api.dto.request.EnrollmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.EnrollmentUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.EnrollmentResponse;

public interface IEnrollmentService extends IBaseService<EnrollmentCreateRequest,EnrollmentUpdateRequest, EnrollmentResponse, String>{
    
}
