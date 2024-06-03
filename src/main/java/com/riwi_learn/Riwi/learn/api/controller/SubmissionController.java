package com.riwi_learn.Riwi.learn.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.SubmissionUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionBaseResponse;
import com.riwi_learn.Riwi.learn.api.dto.response.SubmissionResponse;
import com.riwi_learn.Riwi.learn.infrastructure.services.SubmissionService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(path = "/sumissions")
@AllArgsConstructor
public class SubmissionController {

    private SubmissionService submissionService;

    @PostMapping("")
    public ResponseEntity<SubmissionResponse> create(@RequestBody SubmissionCreateRequest entity) {
        return ResponseEntity.ok().body(submissionService.create(entity));
    }

    @GetMapping("{id}")
    public ResponseEntity<SubmissionResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.submissionService.getById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SubmissionResponse> update(@PathVariable String id, @RequestBody SubmissionUpdateRequest entity) {
        return ResponseEntity.ok().body(this.submissionService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.submissionService.delete(id);
        
        return ResponseEntity.noContent().build();
    }

}
