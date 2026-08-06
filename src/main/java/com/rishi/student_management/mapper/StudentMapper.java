package com.rishi.student_management.mapper;

import com.rishi.student_management.dto.StudentRequestDTO;
import com.rishi.student_management.dto.StudentResponseDTO;
import com.rishi.student_management.model.Student;

public class StudentMapper {

    public static Student toEntity(StudentRequestDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setDepartment(dto.getDepartment());
        student.setAge(dto.getAge());

        return student;
    }

    public static StudentResponseDTO toResponse(Student student) {

        StudentResponseDTO dto = new StudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setDepartment(student.getDepartment());
        dto.setAge(student.getAge());

        return dto;
    }
}
