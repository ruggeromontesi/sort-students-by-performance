package com.uniquex.application.service;

import com.uniquex.application.entity.Student;
import com.uniquex.application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SortingService sortingService;

    public List<Student> getStudentData() {
        //TODO
        Student student1 = new Student("Student1", 8.5);
        Student student2 = new Student("Student2" ,6.5);
        Student student3 = new Student("Student3" ,6.5);
        List<Student> studentList = Arrays.asList(student1,student2, student3);
        return studentRepository.findAll();
    }

    public List<Student> saveStudents(List<Student> studentList) {
        //TODO
        studentRepository.saveAll(studentList);
        return studentRepository.findAll();


    }


    public List<Student> sortStudents() {
        List<Student> studentList = studentRepository.findAll();
        return sortingService.sortStudents();
    }




}
