package com.riwi_learn.Riwi.learn.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi_learn.Riwi.learn.api.dto.request.EnrollmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.EnrollmentResponse;
import com.riwi_learn.Riwi.learn.infrastructure.services.EnrollmentService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "/enrollments")
@AllArgsConstructor
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("")
    public ResponseEntity<EnrollmentResponse> enrollmentUser(@RequestBody EnrollmentCreateRequest request) {
        return ResponseEntity.ok().body(this.enrollmentService.create(request));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.enrollmentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.enrollmentService.delete(id);
        
        return ResponseEntity.noContent().build();
    }
    
}
