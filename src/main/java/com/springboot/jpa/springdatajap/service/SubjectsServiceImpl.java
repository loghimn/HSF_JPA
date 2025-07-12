package com.springboot.jpa.springdatajap.service;

import com.springboot.jpa.springdatajap.model.Subjects;
import com.springboot.jpa.springdatajap.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectsServiceImpl implements SubjectsService {

    @Autowired
    private SubjectsRepository subjectsRepository;

    @Override
    public List<Subjects> findAll() {
        return subjectsRepository.findAll();
    }

    @Override
    public Optional<Subjects> findById(Long id) {
        return subjectsRepository.findById(id);
    }

    @Override
    public Subjects save(Subjects subjects) {
        return subjectsRepository.save(subjects);
    }

    @Override
    public void deleteById(Long id) {
        subjectsRepository.deleteById(id);
    }
}
