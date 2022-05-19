package com.uniquex.application.service;


import com.uniquex.application.entity.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.uniquex.application.repository.*;
import com.uniquex.application.entity.SortingReport;


@Service
public class SortingService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SortingReportRepository sortingReportRepository;

    @Autowired
    private PrintToFileService printToFileService;

    public List<Student> sortStudents(String sortingAlgorithm,boolean saveToFile){

        if(studentRepository.findAll().isEmpty()) {
            return new ArrayList<>();
        }

        List<Student> sortedList = null;

        if(sortingAlgorithm.equals("bubblesort")){
            sortedList =  sortStudentsWithBubbleSort();
        }

        if(sortingAlgorithm.equals("mergesort")){
            sortedList =   sortStudentsWithBubbleSort();
        }

        if(sortingAlgorithm.equals("heapsort")){
            sortedList =   sortStudentsWithHeapSort();
        }

        if(sortedList == null) {
            sortedList =  sortStudentsWithBubbleSort();
        }

        if(saveToFile){
            printToFileService.printToFile(sortedList);
        }

        return sortedList;
    }

    public List<Student> sortStudentsWithBubbleSort(){
        //TODO : IMPLEMENT Bubble sort algorithm
        List<Student> studentList = studentRepository.findAll();
        Instant now = Instant.now();
        studentList.sort(Comparator.comparingDouble(Student::getRating).reversed());
        Instant later = Instant.now();
        Duration duration  = Duration.between(now,later);
        sortingReportRepository.save(new SortingReport(duration,studentList.size(),"bubblesort"));
        studentRepository.deleteAll();
        studentRepository.saveAll(studentList);
        return studentList;
    }

    public List<Student> sortStudentsWithHeapSort(){
        //TODO : IMPLEMENT Bubble sort algorithm
        List<Student> studentList = studentRepository.findAll();
        Instant now = Instant.now();
        studentList.sort(Comparator.comparingDouble(Student::getRating).reversed());
        Instant later = Instant.now();
        Duration duration  = Duration.between(now,later);
        sortingReportRepository.save(new SortingReport(duration,studentList.size(),"heapsort"));
        studentRepository.deleteAll();
        studentRepository.saveAll(studentList);
        return studentList;
    }

    public List<Student> sortStudentsWithMergeSort(){
        //TODO : IMPLEMENT Bubble sort algorithm
        List<Student> studentList = studentRepository.findAll();
        Instant now = Instant.now();
        studentList.sort(Comparator.comparingDouble(Student::getRating).reversed());
        Instant later = Instant.now();
        Duration duration  = Duration.between(now,later);
        sortingReportRepository.save(new SortingReport(duration,studentList.size(),"mergesort"));
        studentRepository.deleteAll();
        studentRepository.saveAll(studentList);
        return studentList;
    }
}
