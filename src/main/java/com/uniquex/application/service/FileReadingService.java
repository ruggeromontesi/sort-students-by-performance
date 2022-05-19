package com.uniquex.application.service;

import com.uniquex.application.entity.Student;
import com.uniquex.application.util.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileReadingService {


    StudentService studentService;

    public FileReadingService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<Student> readFile(String fileName) {
        fileName = "resources/" + fileName;
        List<Student> studentList = CSVReader.parse(fileName);
        studentService.saveStudents(studentList);
        return studentService.saveStudents(studentList);
    }


    public List<Student> readFile(MultipartFile file) {
        String fileName ="";
        List<Student> studentList = CSVReader.parse(file);


        studentService.saveStudents(studentList);
        return studentService.saveStudents(studentList);
    }





}