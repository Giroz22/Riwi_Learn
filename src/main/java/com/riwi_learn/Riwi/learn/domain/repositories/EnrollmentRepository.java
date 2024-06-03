package com.riwi_learn.Riwi.learn.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi_learn.Riwi.learn.domain.entitties.Enrollment;
import com.riwi_learn.Riwi.learn.domain.entitties.User;
import com.riwi_learn.Riwi.learn.domain.entitties.Course;


@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, String>{
    List<Enrollment> findByUser(User user);

    List<Enrollment> findUsersByCourse(Course course);
}
