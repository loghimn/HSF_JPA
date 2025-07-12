package com.springboot.jpa.springdatajap.service;

import com.springboot.jpa.springdatajap.model.Student;
import com.springboot.jpa.springdatajap.model.Subjects;
import com.springboot.jpa.springdatajap.repository.StudentRepository;
import com.springboot.jpa.springdatajap.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectsRepository subjectsRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public Student addSubjectToStudent(Long studentId, Subjects subject) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id = " + studentId));

        subject.setStudent(student);
        subjectsRepository.save(subject); // lưu subject trước

        // Cập nhật danh sách subject của student
        student.getSubjects().add(subject);
        return studentRepository.save(student);
    }
}
