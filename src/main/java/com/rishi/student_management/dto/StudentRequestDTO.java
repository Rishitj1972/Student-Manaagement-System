package com.rishi.student_management.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 3,max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Department is required")
    private String department;

    @Min(value = 18,message = "Age must be at least 18")
    @Max(value = 100, message = "Age cannot be greater than 100")
    private int age;

    public StudentRequestDTO() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
