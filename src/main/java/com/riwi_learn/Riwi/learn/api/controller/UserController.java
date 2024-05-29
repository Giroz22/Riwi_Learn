package com.riwi_learn.Riwi.learn.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi_learn.Riwi.learn.api.dto.request.UserUpdateRequest;
import com.riwi_learn.Riwi.learn.api.dto.request.UserCreateRequest;
import com.riwi_learn.Riwi.learn.api.dto.response.UserResponse;
import com.riwi_learn.Riwi.learn.infrastructure.services.UserService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> findAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "3") int size
    ) {
        return ResponseEntity.ok().body(this.userService.getAll(page-1, size));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(this.userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> add(@RequestBody UserCreateRequest requets) {
        return ResponseEntity.ok().body(this.userService.create(requets));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable String id, @RequestBody UserUpdateRequest entity) {
        return ResponseEntity.ok().body(this.userService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}