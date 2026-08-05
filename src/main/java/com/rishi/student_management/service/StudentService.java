package com.rishi.student_management.service;

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

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student not found"));
    }

    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = studentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Student not found"));

        student.setName(updatedStudent.getName());
        student.setDepartment(updatedStudent.getDepartment());
        student.setAge(updatedStudent.getAge());

        return studentRepository.save(student);
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
