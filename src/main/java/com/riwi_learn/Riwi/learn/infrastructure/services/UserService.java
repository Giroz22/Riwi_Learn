package com.riwi_learn.Riwi.learn.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi_learn.Riwi.learn.api.dto.request.UserCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.UserUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.UserResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.entitties.Message;
import com.riwi_learn.Riwi.learn.domain.entitties.User;
import com.riwi_learn.Riwi.learn.domain.repositories.UserRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.IUserService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.Mapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    @Autowired
    public final UserMapper dtoConverter;

    @Autowired
    public final Mapper mapper;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if(page < 0) page = 0; 

        PageRequest  pagination = PageRequest.of(page, size);

        return this.userRepository.findAll(pagination).map(entity -> this.mapper.userToResponse(entity));
    }

    @Override
    public UserResponse getById(String id) {
        User user = this.userRepository.findById(id).orElse(null);

        UserResponse userResponse = mapper.userToResponse(user);
        return userResponse;
    }

    @Override
    public UserResponse create(UserCreateRequest request) {

        //Obtenemos la info del request
        User user = dtoConverter.requestCreateToEntity(request, new User());  
        // Agregamos algunos valor por defecto
        user.setCourses(new ArrayList<Course>());
        user.setMessagesSent(new ArrayList<Message>());
        user.setMessagesReceived(new ArrayList<Message>());
        
        //Guardamos el usuario
        User newUser = this.userRepository.save(user);

        //Convertimos el usuario a un response
        UserResponse userResponse = this.mapper.userToResponse(newUser);

        //Retornamos el valor
        return userResponse;
    }

    public UserResponse update(String id, UserUpdateRequest request) {
        //Buscar si existe
        User user = this.userRepository.findById(id).orElse(null);

        //Convertir los datos
        User userUpdate = this.dtoConverter.requestUpdateToEntity(request, user);

        //Guardar
        User userUpdated = this.userRepository.save(userUpdate);

        //Convertir a respueste el objeto
        UserResponse userResponse = this.mapper.userToResponse(userUpdated);
        return userResponse;
    }

    @Override
    public void delete(String id) {
        //Buscar si existe
        User user = this.userRepository.findById(id).orElse(null);

        //Eliminamos        
        this.userRepository.delete(user);        
    }

}
