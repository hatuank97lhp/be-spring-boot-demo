package com.example.studentmgn.entity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "stu_class")
public class StuClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_id_seq")
    @SequenceGenerator(
            name = "class_id_seq",
            sequenceName = "class_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String nameAbc;
}
