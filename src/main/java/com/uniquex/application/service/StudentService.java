package com.uniquex.application.service;

import com.uniquex.application.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.uniquex.application.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SortingService sortingService;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Student> saveStudents(List<Student> studentList) {
        studentRepository.saveAll(studentList);
        return studentRepository.findAll();
    }

    public List<Student> sortStudents(String sortingAlgorithm, boolean saveToFile) {
        return sortingService.sortStudents(sortingAlgorithm,saveToFile);
    }

}
