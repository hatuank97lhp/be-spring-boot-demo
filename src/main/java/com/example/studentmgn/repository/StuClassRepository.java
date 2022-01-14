package com.example.studentmgn.repository;

import com.example.studentmgn.entity.model.StuClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StuClassRepository extends JpaRepository<StuClass, Long> {
    List<StuClass> findAll();

    Optional<StuClass> findById(Long id);
}
