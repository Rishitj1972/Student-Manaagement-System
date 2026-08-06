package com.rishi.student_management.controller;

import com.rishi.student_management.dto.StudentRequestDTO;
import com.rishi.student_management.dto.StudentResponseDTO;
import com.rishi.student_management.model.Student;
import com.rishi.student_management.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public StudentResponseDTO addStudent(@RequestBody StudentRequestDTO dto) {
        return studentService.addStudent(dto);
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO student) {
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/exists/{id}")
    public boolean exists(@PathVariable Long id) {
        return studentService.studentExists(id);
    }

    @GetMapping("/count")
    public long count() {
        return studentService.countStudents();
    }
}
