package com.uniquex.application.service;

import com.uniquex.application.entity.Student;
import com.uniquex.application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class SortingService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PrintToFileService printToFileService;

    public List<Student> sortStudents(String sortingAlgorithm,String saveToFile){

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

        if(saveToFile.equals("saveToFile")){
            printToFileService.printToFile(sortedList);
        }

        return sortedList;



    }


    public List<Student> sortStudentsWithBubbleSort(){
        //TODO : IMPLEMENT Bubble sort algorithm

        List<Student> studentList = studentRepository.findAll();
        Collections.sort(studentList, Comparator.comparingDouble(Student::getRating).reversed());
        return studentList;
    }

    public List<Student> sortStudentsWithHeapSort(){
        //TODO : IMPLEMENT Heap sort algorithm

        List<Student> studentList = studentRepository.findAll();
        Collections.sort(studentList, Comparator.comparingDouble(Student::getRating).reversed());
        return studentList;
    }


    public List<Student> sortStudentsWithMergeSort(){
        //TODO : IMPLEMENT Merge sort algorithm

        List<Student> studentList = studentRepository.findAll();
        Collections.sort(studentList, Comparator.comparingDouble(Student::getRating).reversed());
        return studentList;
    }





}
