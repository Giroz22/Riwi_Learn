package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.UserCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.UserUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseToUserResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserMapper{


    public User requestCreateToEntity(UserCreateRequest request, User entity) {

        BeanUtils.copyProperties(request, entity);

        return entity;
    }


    public User requestUpdateToEntity(UserUpdateRequest request, User entity) {

       BeanUtils.copyProperties(request, entity);

        return entity;
    }

    public UserResponse userToResponse(User entity) {

        UserResponse response = new UserResponse();

        BeanUtils.copyProperties(entity, response);

        //Pasar la lista de cursos y mensajes a dto...
        response.setCourses((entity.getCourses().stream().map((course)-> Mapper.sourceToTarget(course, new CourseToUserResponse()) )).toList());

        return response;
    }
}
