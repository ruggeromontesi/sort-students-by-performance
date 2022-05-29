package com.uniquex.application.controller;

import org.hamcrest.Matchers;

import com.uniquex.application.entity.Student;
import com.uniquex.application.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void shouldListAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();

        Student ruggero = new Student().setName("ruggero").setRating(6.0);
        Student michele = new Student().setName("michele").setRating(8.0);
        list.add(ruggero);
        list.add(michele);
        given(this.studentService.getStudents()).willReturn( list );
        //when(this.studentService.getStudents()).thenReturn(list);


        List<Student> newList = new ArrayList<>();
        newList.add(new Student().setName("ruggero").setRating(6.0));
        newList.add(new Student().setName("michele").setRating(8.0));

       this.mvc.perform(get("/read")).andExpect(status().isOk())
               .andExpect(
                       model().attribute("students",newList
                               ));

    }


}
