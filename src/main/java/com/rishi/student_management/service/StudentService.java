package com.rishi.student_management.service;

import com.rishi.student_management.dto.StudentRequestDTO;
import com.rishi.student_management.dto.StudentResponseDTO;
import com.rishi.student_management.mapper.StudentMapper;
import com.rishi.student_management.model.Student;
import com.rishi.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {

        Student student = StudentMapper.toEntity(dto);

        Student savedStudent = studentRepository.save(student);

        return StudentMapper.toResponse(savedStudent);
    }

    public List<StudentResponseDTO> getAllStudents() {

        return studentRepository.findAll().stream()
                .map(StudentMapper::toResponse)
                .toList();
    }

    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student not found"));

        return StudentMapper.toResponse(student);
    }

    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {

        Student student = studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setDepartment(dto.getDepartment());
        student.setAge(dto.getAge());

        Student updatedStudent = studentRepository.save(student);

        return StudentMapper.toResponse(updatedStudent);
    }

    public String deleteStudent(Long id) {

        studentRepository.findById(id).orElseThrow(() -> new
                RuntimeException("Student not found"));

        studentRepository.deleteById(id);

        return "Student Deleted Successfully";
    }

    public boolean studentExists(Long id) {
        return studentRepository.existsById(id); // existsById return true or false;
    }

    public long countStudents() {
        return studentRepository.count();
    }

}
