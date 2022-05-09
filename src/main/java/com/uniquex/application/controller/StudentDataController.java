package com.uniquex.application.controller;

import com.uniquex.application.entity.Student;
import com.uniquex.application.service.FileStorageService;
import com.uniquex.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentDataController {

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

    @PostMapping(value = {"/students/sort"})
    public ResponseEntity<List<Student>> sortStudentsAlternative(@RequestParam String sortingAlgorithm, @RequestParam(name = "saveToFile", defaultValue = "false") Boolean saveToFile) {
        return new ResponseEntity<>(studentService.sortStudents(sortingAlgorithm, saveToFile), HttpStatus.OK);
    }

}