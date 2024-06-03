package com.riwi_learn.Riwi.learn.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.riwi_learn.Riwi.learn.domain.entitties.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, String>{
    
    @Query("select m from messages m where m.sender.id=?1 and receiver.id=?2")
    List<Message> findAllMessages(String sender_id, String receiver_id);
}
