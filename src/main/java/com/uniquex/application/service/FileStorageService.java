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

    public String readFile(String fileName) {
        List<Student> studentList = CSVReader.parse(fileName);
        studentService.saveStudents(studentList);
        return "Output of readFile(MultipartFile file)";
    }
}
