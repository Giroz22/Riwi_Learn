package com.riwi_learn.Riwi.learn.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi_learn.Riwi.learn.domain.entitties.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, String>{
    
}
