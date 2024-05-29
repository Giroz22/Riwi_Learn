package com.riwi_learn.Riwi.learn.infrastructure.abstract_services;


import com.riwi_learn.Riwi.learn.api.dto.request.LessonCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.LessonUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonResponse;

public interface ILessonService extends IBaseService<LessonCreateRequest, LessonUpdateRequest, LessonResponse, String>{
    
}
