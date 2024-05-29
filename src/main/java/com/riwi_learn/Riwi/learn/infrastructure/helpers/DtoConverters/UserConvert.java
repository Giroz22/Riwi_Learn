package com.riwi_learn.Riwi.learn.infrastructure.helpers.DtoConverters;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.UserCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.UserUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.UserResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.User;

@Component
public class UserConvert{

    public User requestCreateToEntity(UserCreateRequest request, User entity) {

        BeanUtils.copyProperties(request, entity);

        return entity;
    }


    public User requestUpdateToEntity(UserUpdateRequest request, User entity) {

        BeanUtils.copyProperties(request, entity);

        return entity;
    }

    public UserResponse EntityToResponse(User entity) {

        UserResponse response = new UserResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

}
