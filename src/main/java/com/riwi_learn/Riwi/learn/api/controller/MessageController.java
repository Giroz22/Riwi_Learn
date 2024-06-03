package com.riwi_learn.Riwi.learn.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi_learn.Riwi.learn.api.dto.request.MessageSendRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageResponse;
import com.riwi_learn.Riwi.learn.infrastructure.services.MessageService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/messages")
@AllArgsConstructor
public class MessageController {
    @Autowired
    private MessageService messageService;
     @PostMapping("")
    public ResponseEntity<MessageResponse> send(@RequestBody MessageSendRequest request) {
        return ResponseEntity.ok().body(this.messageService.send(request));
    }

    @GetMapping("")
    public ResponseEntity<List<MessageResponse>> getAllMessage(@RequestParam String sender_id, @RequestParam String receiver_id) {
        return ResponseEntity.ok().body(this.messageService.getAll(sender_id, receiver_id));
    }
}
