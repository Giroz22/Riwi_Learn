package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.UserCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.UserUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.UserBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserMapper implements IMapperBase<User, UserCreateRequest,  UserResponse>{

    @Override   
    public User requestToEntity(UserCreateRequest request) {

        User entity = Mapper.sourceToTarget(request, new User());

        return entity;
    }

    public User requestToEntity(UserUpdateRequest request, User entity) {

       BeanUtils.copyProperties(request, entity);

        return entity;
    }

    @Override
    public UserResponse entityToResponse(User entity) {

        UserResponse response = new UserResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    public UserBaseResponse entityToBaseResponse(User entity){        
        UserBaseResponse response = Mapper.sourceToTarget(entity, new UserBaseResponse());

        return response;
    }
}
