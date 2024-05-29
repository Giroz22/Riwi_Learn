package com.riwi_learn.Riwi.learn.infrastructure.abstract_services;

import com.riwi_learn.Riwi.learn.api.dto.request.CourseCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.CourseUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseResponse;

public interface ICourseService extends IBaseService<CourseCreateRequest, CourseUpdateRequest,CourseResponse, String>{
    
}
