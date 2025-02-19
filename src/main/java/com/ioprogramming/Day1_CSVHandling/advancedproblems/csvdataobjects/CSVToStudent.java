package com.ioprogramming.Day1_CSVHandling.advancedproblems.csvdataobjects;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudent {

    public static List<Student> readCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return students;
            }

            for (int i = 1; i < records.size(); i++) { // Skip header row
                String[] record = records.get(i);
                if (record.length < 4) continue; // Skip malformed rows

                try {
                    int id = Integer.parseInt(record[0]);   // ID
                    String name = record[1];               // Name
                    int age = Integer.parseInt(record[2]); // Age
                    double marks = Double.parseDouble(record[3]); // Marks
                    students.add(new Student(id, name, age, marks));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid row: " + String.join(",", record));
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static void main(String[] args) {
        String filePath = "C:\\my doucments\\files\\updatedemployee.csv";
        List<Student> students = readCSV(filePath);
        students.forEach(System.out::println);
    }
}
