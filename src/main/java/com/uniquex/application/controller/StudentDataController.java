package com.uniquex.application.controller;

import com.uniquex.application.entity.Student;
import com.uniquex.application.service.FileStorageService;
import com.uniquex.application.service.StudentDataService;
import com.uniquex.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class StudentDataController {

    @Autowired
    private StudentDataService studentDataService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/students")
    public List<Student> getStudentData() {
        final List<Student> studentData = studentService.getStudentData();
        return studentData;
    }



    @PostMapping("/uploadFile/{fileName}")
    public String uploadFile(@PathVariable("fileName") String fileName) {
        fileName= "resources/" + fileName;
        String output = fileStorageService.readFile(fileName);
        return "dummyOutput";

    }


    @GetMapping("/students/sort/{sortingAlgorithm}/{saveToFile}")
    public List<Student> sortStudents(@PathVariable("sortingAlgorithm") String sortingAlgorithm,@PathVariable("saveToFile") String saveToFile ) {
        final List<Student> studentData = studentService.sortStudents(sortingAlgorithm, saveToFile);
        return studentData;
    }






}
