package com.ioprogramming.Day1_CSVHandling.advancedproblems.mergecsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV {

    public static void mergeCSVFiles(String file1Path, String file2Path, String outputPath) {
        try (CSVReader reader1 = new CSVReader(new FileReader(file1Path));
             CSVReader reader2 = new CSVReader(new FileReader(file2Path));
             CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {

            Map<String, String[]> students1Data = new HashMap<>();
            String[] header1 = reader1.readNext();
            String[] header2 = reader2.readNext();

            String[] outputHeader = new String[] {"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(outputHeader);


            String[] record1;
            while ((record1 = reader1.readNext()) != null) {
                students1Data.put(record1[0], record1);
            }


            String[] record2;
            while ((record2 = reader2.readNext()) != null) {
                String studentId = record2[0];
                if (students1Data.containsKey(studentId)) {
                    String[] student1 = students1Data.get(studentId);

                    String[] mergedRecord = new String[] {
                            studentId, student1[1], student1[2], record2[1], record2[2]
                    };
                    writer.writeNext(mergedRecord);
                }
            }

            System.out.println("CSV files merged successfully!");

        } catch (IOException e) {
            System.err.println("Error reading/writing CSV files: " + e.getMessage());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file1Path = "E:/Capg/Week5_IO_Programming/Day1/src/main/resources/students1.csv";  // students1.csv path
        String file2Path = "E:/Capg/Week5_IO_Programming/Day1/src/main/resources/students2.csv";  // students2.csv path
        String outputPath = "E:/Capg/Week5_IO_Programming/Day1/src/main/resources/merged_students.csv";  // Output file path

        mergeCSVFiles(file1Path, file2Path, outputPath);
    }
}
