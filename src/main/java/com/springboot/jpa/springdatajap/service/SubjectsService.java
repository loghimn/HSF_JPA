package com.springboot.jpa.springdatajap.service;

    import com.springboot.jpa.springdatajap.model.Subjects;
    import java.util.List;
    import java.util.Optional;

    public interface SubjectsService {
        List<Subjects> findAll();
        Optional<Subjects> findById(Long id);
        Subjects save(Subjects subjects);
        void deleteById(Long id);
    }