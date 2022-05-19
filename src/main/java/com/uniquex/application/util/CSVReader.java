package com.uniquex.application.util;




import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.uniquex.application.entity.Student;
import org.springframework.web.multipart.MultipartFile;

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


   public static List<Student> parse(MultipartFile file)  {

      String line = "";
      String cvsSplitBy = ",";
      List<Student> students = new ArrayList<>();

      Reader reader  = null;

      try {
         reader = new InputStreamReader(file.getInputStream());
         BufferedReader br = new BufferedReader(reader);
         while ((line = br.readLine()) != null && line.contains(",")) {

            String[] studentResult = line.split(cvsSplitBy);
            Student student = new Student()
                  .setName(studentResult[0])
                  .setRating(Double.parseDouble(studentResult[1]));

            students.add(student);
         }
      }catch (IOException ex) {
         System.out.println("exc!");
      }


      return students;

   }





}
