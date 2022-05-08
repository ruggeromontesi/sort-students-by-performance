package com.uniquex.application.util;


import com.uniquex.application.entity.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
   public static List<Student> parse(String csvFile) {

      String line = "";
      String cvsSplitBy = ",";

      List<Student> students = new ArrayList<>();

      try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

         while ((line = br.readLine()) != null && line.contains(",")) {

            String[] studentResult = line.split(cvsSplitBy);
            Student student = new Student()
                  .setName(studentResult[0])
                  .setRating(Double.parseDouble(studentResult[1]));


            students.add(student);
         }
         return students;

      } catch (IOException e) {
         throw new RuntimeException("Error while parsing", e);
      }

   }
}
