package com.uniquex.application.service;

import com.uniquex.application.entity.Student;
import com.uniquex.application.util.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileStorageService {

    @Autowired
    StudentService studentService;

    public List<Student> readFile(String fileName) {
        fileName = "resources/" + fileName;
        List<Student> studentList = CSVReader.parse(fileName);
        studentService.saveStudents(studentList);
        return studentService.saveStudents(studentList);
    }
}