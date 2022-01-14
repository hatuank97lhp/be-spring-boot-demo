package com.example.studentmgn.repository;

import com.example.studentmgn.entity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Optional<Student> findById(Long id);

    List<Student> findAllByNameContains(String name);

    List<Student> findAllByStuClassId(Long classId);
}
