package com.example.studentmgn.controller;

import com.example.studentmgn.common.APIResponse;
import com.example.studentmgn.entity.request.StudentRequest;
import com.example.studentmgn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @PostMapping
    public ResponseEntity<APIResponse> addNewStudent(@RequestBody @Valid StudentRequest studentRequest) {
        ResponseEntity<APIResponse> response = studentService.addNewStudent(studentRequest);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getStudentById(@PathVariable Long id) {
        ResponseEntity<APIResponse> response = studentService.getStudentById(id);
        return response;
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllStudent() {
        ResponseEntity<APIResponse> response = studentService.getAll();
        return response;
    }

    @GetMapping("/filter")
    public ResponseEntity<APIResponse> getStudentByName(@PathParam("name") String name) {
        ResponseEntity<APIResponse> response = studentService.getStudentByName(name);
        return response;
    }

    @GetMapping("/class-{id}")
    public ResponseEntity<APIResponse> getStudentByClassId(@PathVariable Long id) {
        ResponseEntity<APIResponse> response = studentService.getStudentByClassId(id);
        return response;
    }


}
