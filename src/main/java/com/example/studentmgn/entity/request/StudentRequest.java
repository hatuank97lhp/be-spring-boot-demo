package com.example.studentmgn.entity.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentRequest {
    private String name;

    private String email;

    private Long classId;
}
