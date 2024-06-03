package com.riwi_learn.Riwi.learn.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi_learn.Riwi.learn.api.dto.request.CourseCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.CourseUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.CourseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.LessonBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.MessageResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.UserBaseResponse;
import com.riwi_learn.Riwi.learn.infrastructure.services.CourseService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "/courses")
@AllArgsConstructor
public class CourseController {
    
    @Autowired
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseResponse>> findAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "3") int size 
    ) {
        return ResponseEntity.ok().body(this.courseService.getAll( page-1, size ));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> findById(@PathVariable String id){
        return ResponseEntity.ok().body(this.courseService.getById(id));
    }

    @GetMapping("/{id}/lessons")
    public ResponseEntity<List<LessonBaseResponse>> findLessons(@PathVariable String id){
        return ResponseEntity.ok().body(this.courseService.getLessons(id));
    }

    @PostMapping
    public ResponseEntity<CourseResponse> save(@RequestBody CourseCreateRequest request){
        System.out.println(request);
        return ResponseEntity.ok().body(this.courseService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponse> update(@PathVariable String id, @RequestBody CourseUpdateRequest request){
        return ResponseEntity.ok().body(this.courseService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourseResponse> delete(@PathVariable String id){
        this.courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<List<UserBaseResponse>> getUsersInCourse(@PathVariable String id) {
        return ResponseEntity.ok().body(this.courseService.getAllUsersInCourse(id));
    }

    @GetMapping("/{id}/messages")
    public ResponseEntity<List<MessageBaseResponse>> getAllMessages(@PathVariable String id) {
        return ResponseEntity.ok().body(this.courseService.getAllMessages(id));
    }
}
