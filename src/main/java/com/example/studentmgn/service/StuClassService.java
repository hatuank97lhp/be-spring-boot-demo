package com.example.studentmgn.service;

import com.example.studentmgn.common.APIResponse;
import com.example.studentmgn.common.Message;
import com.example.studentmgn.entity.model.StuClass;
import com.example.studentmgn.entity.request.StuClassRequest;
import com.example.studentmgn.repository.StuClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StuClassService {
    @Autowired
    private StuClassRepository classRepository;

    @Transactional
    public ResponseEntity<APIResponse> addNewClass(StuClassRequest stuClassRequest) {
        // tao 1 lop co ten la stuClassRequest.name

        StuClass stuClass = new StuClass();
        stuClass.setNameAbc(stuClassRequest.getName());
        classRepository.save(stuClass);

        return ResponseEntity.ok().body(APIResponse.buildResponse(Message.API_SUCCESS, stuClass));
    }

    @ReadOnlyProperty
    public ResponseEntity<APIResponse> getAllClass() {
        List<StuClass> stuClasses = classRepository.findAll();

        return ResponseEntity.ok().body(APIResponse.buildResponse(Message.API_SUCCESS, stuClasses));
    }

    @ReadOnlyProperty
    public ResponseEntity<APIResponse> getClassById(Long id) {
        Optional<StuClass> stuClassOptional = classRepository.findById(id);

        if (stuClassOptional.isPresent()) {
            return ResponseEntity.ok().body(APIResponse.buildResponse(Message.API_SUCCESS, stuClassOptional.get()));
        }

        return ResponseEntity.badRequest().body(APIResponse.buildResponse(Message.CLASS_ID_NOT_FOUND));
    }

    @Transactional
    public ResponseEntity<APIResponse> updateClassById(Long id, StuClassRequest stuClassRequest) {
        Optional<StuClass> stuClassOptional = classRepository.findById(id);
        if (!stuClassOptional.isPresent()) {
            return ResponseEntity.badRequest().body(APIResponse.buildResponse(Message.CLASS_ID_NOT_FOUND));
        }

        StuClass stuClass = stuClassOptional.get();
        stuClass.setNameAbc(stuClassRequest.getName());
        classRepository.save(stuClass);

        return ResponseEntity.ok().body(APIResponse.buildResponse(Message.API_SUCCESS, stuClass));
    }
}
