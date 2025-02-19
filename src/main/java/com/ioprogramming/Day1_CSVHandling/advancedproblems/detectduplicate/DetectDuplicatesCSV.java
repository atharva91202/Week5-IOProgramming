package com.ioprogramming.Day1_CSVHandling.advancedproblems.detectduplicate;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicatesCSV {


        public static void detectDuplicates(String filePath) {
            Set<String> seenIds = new HashSet<>();  // Set to track unique IDs
            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                String[] header = reader.readNext();  // Skip header row (ID, Name, Age, Marks)
                String[] record;
                boolean hasDuplicates = false;

                while ((record = reader.readNext()) != null) {
                    String studentId = record[0];  // Assuming ID is in the first column

                    // Check if the ID is already seen
                    if (seenIds.contains(studentId)) {
                        // Print the duplicate record
                        System.out.println("Duplicate record: " + String.join(", ", record));
                        hasDuplicates = true;
                    } else {
                        seenIds.add(studentId);  // Add the ID to the set
                    }
                }

                if (!hasDuplicates) {
                    System.out.println("No duplicate records found.");
                }

            } catch (IOException e) {
                System.err.println("Error reading CSV file: " + e.getMessage());
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
        }

        public static void main(String[] args) {
            String filePath = "C:\\my doucments\\files\\updatedemployee.csv";
            detectDuplicates(filePath);
        }
    }
