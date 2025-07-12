package com.springboot.jpa.springdatajap.service;

import com.springboot.jpa.springdatajap.model.Student;
import com.springboot.jpa.springdatajap.model.Subjects;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Student save(Student student);
    void deleteById(Long id);
    Student addSubjectToStudent(Long studentId, Subjects subject);
}