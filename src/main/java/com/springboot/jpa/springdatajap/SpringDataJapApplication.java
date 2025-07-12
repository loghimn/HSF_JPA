package com.springboot.jpa.springdatajap;

import com.springboot.jpa.springdatajap.model.Category;
import com.springboot.jpa.springdatajap.model.Student;
import com.springboot.jpa.springdatajap.model.Subjects;
import com.springboot.jpa.springdatajap.repository.CategoryRepository;
import com.springboot.jpa.springdatajap.repository.StudentRepository;
import com.springboot.jpa.springdatajap.repository.SubjectsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringDataJapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJapApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(
            CategoryRepository categoryRepository,
            StudentRepository studentRepository,
            SubjectsRepository subjectsRepository) {

        return args -> {
            // 1. Load categories
            Category math = categoryRepository.findAll().stream()
                    .filter(c -> "Math".equals(c.getCateName()))
                    .findFirst()
                    .orElseGet(() -> {
                        Category c = new Category();
                        c.setCateName("Math");
                        return categoryRepository.save(c);
                    });

            Category science = categoryRepository.findAll().stream()
                    .filter(c -> "Science".equals(c.getCateName()))
                    .findFirst()
                    .orElseGet(() -> {
                        Category c = new Category();
                        c.setCateName("Science");
                        return categoryRepository.save(c);
                    });

            // 2. Load students
            Student s1 = studentRepository.findAll().stream()
                    .filter(s -> "student1".equals(s.getUserName()))
                    .findFirst()
                    .orElseGet(() -> {
                        Student student = new Student();
                        student.setCode("C001");
                        student.setName("Student One");
                        student.setUserName("student1");
                        student.setPassword("pass1"); // Đã sửa lỗi
                        student.setStatus("active");
                        return studentRepository.save(student);
                    });

            Student s2 = studentRepository.findAll().stream()
                    .filter(s -> "student2".equals(s.getUserName()))
                    .findFirst()
                    .orElseGet(() -> {
                        Student student = new Student();
                        student.setCode("C002");
                        student.setName("Student Two");
                        student.setUserName("student2");
                        student.setPassword("pass2");
                        student.setStatus("active");
                        return studentRepository.save(student);
                    });

            // 3. Load subjects (và gán Student + Category)
            if (subjectsRepository.findAll().stream().noneMatch(s -> "Algebra".equals(s.getSubjectName()))) {
                Subjects algebra = new Subjects();
                algebra.setSubjectName("Algebra");
                algebra.setSubjectCode("ALG101");
                algebra.setStudent(s1); // Gán student1
                Set<Category> categories = new HashSet<>();
                categories.add(math);
                algebra.setCategories(categories);
                subjectsRepository.save(algebra);
            }

            if (subjectsRepository.findAll().stream().noneMatch(s -> "Physics".equals(s.getSubjectName()))) {
                Subjects physics = new Subjects();
                physics.setSubjectName("Physics");
                physics.setSubjectCode("PHY101");
                physics.setStudent(s2); // Gán student2
                Set<Category> categories = new HashSet<>();
                categories.add(science);
                physics.setCategories(categories);
                subjectsRepository.save(physics);
            }
        };
    }
}
