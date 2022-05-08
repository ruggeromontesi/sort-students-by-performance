package com.uniquex.application.service;

import com.uniquex.application.entity.Student;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.uniquex.application.constants.Constants.RESULT_DIRECTORY;
import static com.uniquex.application.constants.Constants.RESULT_FILENAME;

@Service
public class PrintToFileService {



    public void printToFile(List<Student> sortedList){
        File directory = new File(RESULT_DIRECTORY);
        if (!directory.exists()){
            directory.mkdirs();
        }

        BufferedWriter writer = null;

        try {
            StringBuffer output = new StringBuffer("");
            writer = new BufferedWriter(new FileWriter(RESULT_DIRECTORY + "/" + RESULT_FILENAME));

            sortedList.forEach(student -> output.append(student.toString() + "\n"));

            writer.write(output.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
