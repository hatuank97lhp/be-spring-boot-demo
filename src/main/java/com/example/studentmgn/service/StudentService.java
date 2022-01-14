package com.example.studentmgn.service;

import com.example.studentmgn.common.APIResponse;
import com.example.studentmgn.common.Message;
import com.example.studentmgn.entity.model.StuClass;
import com.example.studentmgn.entity.model.Student;
import com.example.studentmgn.entity.request.StudentRequest;
import com.example.studentmgn.repository.StuClassRepository;
import com.example.studentmgn.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StuClassRepository classRepository;

    @Transactional
    public ResponseEntity<APIResponse> addNewStudent(StudentRequest studentRequest) {
        Optional<StuClass> classOptional = classRepository.findById(studentRequest.getClassId());
        if (!classOptional.isPresent()) {
            return ResponseEntity.badRequest().body( APIResponse.buildResponse(Message.CLASS_ID_NOT_FOUND) );
        }

        Student student = new Student();

        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setStuClass(classOptional.get());

        studentRepository.save(student);
        return ResponseEntity.ok().body(APIResponse.buildResponse(Message.API_SUCCESS, student));
    }

    @ReadOnlyProperty
    public ResponseEntity<APIResponse> getStudentById(Long id) {
        Optional<Student> students = studentRepository.findById(id);

        return ResponseEntity.ok().body(APIResponse.buildResponse(Message.API_SUCCESS, students));
    }

    @ReadOnlyProperty
    public ResponseEntity<APIResponse> getAll() {
        List<Student> students = studentRepository.findAll();

        return ResponseEntity.ok().body(APIResponse.buildResponse(Message.API_SUCCESS, students));
    }

    @ReadOnlyProperty
    public ResponseEntity<APIResponse> getStudentByName(String name) {
        List<Student> students = studentRepository.findAllByNameContains(name);
        return ResponseEntity.ok().body(APIResponse.buildResponse(Message.API_SUCCESS, students));
    }

    @ReadOnlyProperty
    public ResponseEntity<APIResponse> getStudentByClassId(Long classId) {
        List<Student> students = studentRepository.findAllByStuClassId(classId);
        return ResponseEntity.ok().body(APIResponse.buildResponse(Message.API_SUCCESS, students));
    }
}
