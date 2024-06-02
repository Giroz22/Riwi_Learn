package com.riwi_learn.Riwi.learn.infrastructure.helpers.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.riwi_learn.Riwi.learn.api.dto.request.EnrollmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.EnrollmentResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserBaseResponse;
import com.riwi_learn.Riwi.learn.domain.entitties.Enrollment;
import com.riwi_learn.Riwi.learn.domain.repositories.CourseRepository;
import com.riwi_learn.Riwi.learn.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentMapper implements IMapperBase<Enrollment, EnrollmentCreateRequest, EnrollmentResponse>{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Enrollment requestToEntity(EnrollmentCreateRequest request) {
        Enrollment entity = Mapper.sourceToTarget(request, new Enrollment());

        entity.setUser(
            this.userRepository.findById(request.getUser_id()).orElse(null)
        );

        entity.setCourse(
            this.courseRepository.findById(request.getCourse_id()).orElse(null)
        );

        return entity;
    }

    @Override
    public EnrollmentResponse entityToResponse(Enrollment entity) {

        EnrollmentResponse response = Mapper.sourceToTarget(entity, new EnrollmentResponse());

        response.setUser(
            Mapper.sourceToTarget(entity.getUser(), new UserBaseResponse())
        );

        response.setCourse(
            Mapper.sourceToTarget(
                entity.getCourse(), 
                courseMapper.entityToBaseResponse(entity.getCourse())
            )
        );

        return response;
    }
    
}
