package com.ioprogramming.Day1_CSVHandling.intermediateproblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ModifyFile {
    public static void updateSalaries(String inputFile, String outputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> records = reader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }


            for (int i = 0; i < records.size(); i++) {
                String[] record = records.get(i);
                if (i == 0) {

                    writer.writeNext(record);
                    continue;
                }

                if (record.length < 4) continue;

                String department = record[2];
                if ("IT".equalsIgnoreCase(department)) {
                    try {
                        double salary = Double.parseDouble(record[3]); // Salary column
                        salary *= 1.10; // Increase by 10%
                        record[3] = String.format("%.2f", salary);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid salary data: " + record[3]);
                    }
                }
                writer.writeNext(record);
            }

            System.out.println("Updated salaries saved to: " + outputFile);

        } catch (IOException e) {
            System.err.println("Error processing CSV file: " + e.getMessage());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String inputFile = "C:\\my doucments\\files\\employee.csv";
        String outputFile ="C:\\my doucments\\files\\updatedemployee.csv";
        updateSalaries(inputFile, outputFile);
    }
}

