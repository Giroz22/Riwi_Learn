package com.riwi_learn.Riwi.learn.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi_learn.Riwi.learn.domain.entitties.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, String>{
    
}
