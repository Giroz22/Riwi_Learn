package com.riwi_learn.Riwi.learn.infrastructure.abstract_services;

import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentResponse;

public interface IAssigmentService extends IBaseService<AssigmentCreateRequest, AssigmentUpdateRequest,AssigmentResponse, String>{
    
}
