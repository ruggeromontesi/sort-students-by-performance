package com.uniquex.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentFileStorageServiceImplementationTest {

    @Autowired
    private  StudentFileStorageServiceImplementation  studentFileStorageService;

    @Test
    public void loadAllTest() {
        if (studentFileStorageService == null ) {
            throw new RuntimeException();
        }
        studentFileStorageService.loadAll();

    }
}
