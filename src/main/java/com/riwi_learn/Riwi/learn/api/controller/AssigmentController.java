package com.riwi_learn.Riwi.learn.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.AssigmentUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.AssigmentResponse;
import com.riwi_learn.Riwi.learn.infrastructure.services.AssigmentService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping(path = "/assigments")
@AllArgsConstructor
public class AssigmentController {
    
    @Autowired
    AssigmentService assigmentService;

    @GetMapping("/{id}")
    public ResponseEntity<AssigmentResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.assigmentService.getById(id));
    }    
    
    @PostMapping("")
    public ResponseEntity<AssigmentResponse> create(@RequestBody AssigmentCreateRequest request) {
        return ResponseEntity.ok().body(this.assigmentService.create(request));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AssigmentResponse> update(@PathVariable String id, @RequestBody AssigmentUpdateRequest request) {
        return ResponseEntity.ok().body(this.assigmentService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.assigmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
