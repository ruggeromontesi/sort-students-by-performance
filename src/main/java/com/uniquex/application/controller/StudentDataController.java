package com.uniquex.application.controller;

import com.uniquex.application.entity.Student;
import com.uniquex.application.service.FileStorageService;
import com.uniquex.application.service.StudentDataService;
import com.uniquex.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
        final List<Student> studentData = studentService.getStudents();
        return studentData;
    }

    @PostMapping("/uploadFile/{fileName}")
    public ResponseEntity<List<Student>> uploadFile(@PathVariable("fileName") String fileName) {

        return new ResponseEntity<>(fileStorageService.readFile(fileName), HttpStatus.OK);
    }

    @GetMapping(value = {"/students/sort/{sortingAlgorithm}/{saveToFile}", "/students/sort/{sortingAlgorithm}"})
    public ResponseEntity<List<Student>> sortStudents(@PathVariable("sortingAlgorithm") String sortingAlgorithm, @PathVariable(value = "saveToFile", required = false) String saveToFile) {
        saveToFile = saveToFile != null ? saveToFile : "";
                return new ResponseEntity<>(studentService.sortStudents(sortingAlgorithm, saveToFile), HttpStatus.OK);
    }
}
