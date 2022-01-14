package com.example.studentmgn.controller;

import com.example.studentmgn.common.APIResponse;
import com.example.studentmgn.entity.request.StuClassRequest;
import com.example.studentmgn.service.StuClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/class")
public class StuClassController {
    @Autowired
    private StuClassService classService;

    @PostMapping
    public ResponseEntity<APIResponse> addNewClass(@RequestBody @Valid StuClassRequest classRequest) {
        ResponseEntity<APIResponse> response = classService.addNewClass(classRequest);
        return response;
    }

    @GetMapping
    public ResponseEntity<APIResponse> getAllClass() {
        ResponseEntity<APIResponse> response = classService.getAllClass();
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getClassById(@PathVariable Long id) {
        ResponseEntity<APIResponse> response = classService.getClassById(id);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updateClassById(@PathVariable Long id, @RequestBody @Valid StuClassRequest stuClassRequest) {
        ResponseEntity<APIResponse> response = classService.updateClassById(id, stuClassRequest);
        return response;
    }
}
