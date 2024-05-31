package com.riwi_learn.Riwi.learn.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi_learn.Riwi.learn.api.dto.request.LessonCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.LessonUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonResponse;
import com.riwi_learn.Riwi.learn.infrastructure.services.LessonService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LessonController {
    
    @Autowired
    LessonService lessonService;

    @GetMapping("/{id}")
    public ResponseEntity<LessonResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.lessonService.getById(id));
    }
    
    @PostMapping
    public ResponseEntity<LessonResponse> create(@RequestBody LessonCreateRequest request) {
        return ResponseEntity.ok().body(this.lessonService.create(request));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<LessonResponse> update(@PathVariable String id, @RequestBody LessonUpdateRequest request) {
        return ResponseEntity.ok().body(this.lessonService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        this.lessonService.delete(id);
        return ResponseEntity.noContent().build();
    }
        
}
