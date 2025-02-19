package com.ioprogramming.Day1_CSVHandling.advancedproblems.csvvalidator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


class CSVValidatorTest {

        private static final String TEST_CSV_FILE ="C:\\my doucments\\files\\updatedemployee.csv";

        @Test
        public void testCSVValidation() throws IOException {
            // Create a test CSV file
            createTestCSV();

            // Read the file and check if there are invalid entries
            List<String> lines = Files.readAllLines(Paths.get(TEST_CSV_FILE));
            boolean hasInvalidEmail = lines.stream().anyMatch(line -> line.contains("invalid_email"));
            boolean hasInvalidPhone = lines.stream().anyMatch(line -> line.contains("12345")); // Invalid phone

            assertTrue(hasInvalidEmail);
            assertTrue(hasInvalidPhone);
        }

        private void createTestCSV() throws IOException {
            try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
                writer.println("ID,Email,Phone");
                writer.println("101,anandsoni9165@gmail.com,9876543210");
                writer.println("102,invalid_email,9876543210"); // Invalid email
                writer.println("103,ankit@123.com,12345");
            }
        }
    }
