package com.riwi_learn.Riwi.learn.infrastructure.abstract_services;

import com.riwi_learn.Riwi.learn.api.dto.request.UserCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.UserUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.UserResponse;

public interface IUserService extends IBaseService<UserCreateRequest, UserUpdateRequest, UserResponse, String>{
    
}
