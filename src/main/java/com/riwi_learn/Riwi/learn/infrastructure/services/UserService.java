package com.riwi_learn.Riwi.learn.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi_learn.Riwi.learn.api.dto.request.UserCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.UserUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Course;
import com.riwi_learn.Riwi.learn.domain.entitties.Enrollment;
import com.riwi_learn.Riwi.learn.domain.entitties.Message;
import com.riwi_learn.Riwi.learn.domain.entitties.User;
import com.riwi_learn.Riwi.learn.domain.repositories.EnrollmentRepository;
import com.riwi_learn.Riwi.learn.domain.repositories.UserRepository;
import com.riwi_learn.Riwi.learn.infrastructure.abstract_services.IUserService;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.CourseMapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.SubmissionMapper;
import com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    @Autowired
    public final UserMapper UserMapper;
    
    @Autowired
    public final CourseMapper courseMapper;

    @Autowired
    private final SubmissionMapper submissionMapper;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if(page < 0) page = 0; 

        PageRequest  pagination = PageRequest.of(page, size);

        return this.userRepository.findAll(pagination).map(entity -> this.UserMapper.entityToResponse(entity));
    }

    @Override
    public UserResponse getById(String id) {
        User user = this.userRepository.findById(id).orElse(null);

        UserResponse userResponse = UserMapper.entityToResponse(user);
        return userResponse;
    }

    @Override
    public UserResponse create(UserCreateRequest request) {

        //Obtenemos la info del request
        User user = UserMapper.requestToEntity(request); 

        // Agregamos algunos valor por defecto
        user.setCourses(new ArrayList<Course>());
        user.setMessagesSent(new ArrayList<Message>());
        user.setMessagesReceived(new ArrayList<Message>());
        user.setEnrollments(new ArrayList<>());
        user.setSubmissions(new ArrayList<>());
        
        //Guardamos el usuario
        User newUser = this.userRepository.save(user);

        //Convertimos el usuario a un response
        UserResponse userResponse = this.UserMapper.entityToResponse(newUser);

        //Retornamos el valor
        return userResponse;
    }

    public UserResponse update(String id, UserUpdateRequest request) {
        //Buscar si existe
        User user = this.userRepository.findById(id).orElse(null);

        //Convertir los datos
        User userUpdate = this.UserMapper.requestToEntity(request, user);

        //Guardar
        User userUpdated = this.userRepository.save(userUpdate);

        //Convertir a respueste el objeto
        UserResponse userResponse = this.UserMapper.entityToResponse(userUpdated);
        return userResponse;
    }

    @Override
    public void delete(String id) {
        //Buscar si existe
        User user = this.userRepository.findById(id).orElse(null);

        //Eliminamos        
        this.userRepository.delete(user);        
    }

    public List<CourseBaseResponse> getCourses(String user_id){
        User user = this.userRepository.findById(user_id).orElse(null);

        List<Enrollment> enrollments = enrollmentRepository.findByUser(user);

        return enrollments.stream().map(
            enrollment -> courseMapper.entityToBaseResponse(enrollment.getCourse()) 
        ).toList();
    }

    public List<SubmissionBaseResponse>  getAllSubmission(String user_id){
        User user =   this.userRepository.findById(user_id).orElse(null);

        return user.getSubmissions().stream().map(
            (submission) -> this.submissionMapper.entityToBaseResponse(submission)
        ).toList();
    }
}
