package com.ioprogramming.Day1_CSVHandling.advancedproblems.csvvalidator;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;


public class CSVValidator {


        private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");

        public static void validateCSV(String filePath) {
            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                List<String[]> records = reader.readAll();
                if (records.isEmpty()) {
                    System.out.println("CSV file is empty!");
                    return;
                }

                boolean hasInvalidRows = false;
                System.out.println("Validating CSV Data...");

                // Validate each row, skipping the header
                for (int i = 1; i < records.size(); i++) {
                    String[] record = records.get(i);
                    if (record.length < 3) continue; // Skip malformed rows

                    String email = record[1];  // Assuming Email is in the second column
                    String phone = record[2];  // Assuming Phone Number is in the third column

                    if (!EMAIL_PATTERN.matcher(email).matches()) {
                        System.out.println("Invalid Email at row " + (i + 1) + ": " + email);
                        hasInvalidRows = true;
                    }
                    if (!PHONE_PATTERN.matcher(phone).matches()) {
                        System.out.println("Invalid Phone Number at row " + (i + 1) + ": " + phone);
                        hasInvalidRows = true;
                    }
                }

                if (!hasInvalidRows) {
                    System.out.println("All records are valid!");
                }

            } catch (IOException e) {
                System.err.println("Error reading CSV file: " + e.getMessage());
            } catch (CsvException e) {
                throw new RuntimeException(e);
            }
        }

        public static void main(String[] args) {
            String filePath = "C:\\my doucments\\files\\updatedemployee.csv";
            validateCSV(filePath);
        }
    }

