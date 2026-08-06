package com.rishi.student_management.dto;

public class StudentRequestDTO {

    private String name;
    private String department;
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
    public void setName(int age) {
        this.age = age;
    }

}
