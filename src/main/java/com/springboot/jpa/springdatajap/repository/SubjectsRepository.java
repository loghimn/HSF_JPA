package com.springboot.jpa.springdatajap.repository;

    import com.springboot.jpa.springdatajap.model.Subjects;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
    }