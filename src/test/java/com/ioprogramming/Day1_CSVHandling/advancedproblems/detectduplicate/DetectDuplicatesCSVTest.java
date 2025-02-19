package com.ioprogramming.Day1_CSVHandling.advancedproblems.detectduplicate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DetectDuplicatesCSVTest {


        private final String testFilePath = "C:\\my doucments\\files\\updatedemployee.csv";

        // Helper method to create a sample CSV file for testing
        private void createTestCSV() {
            try (FileWriter writer = new FileWriter(testFilePath)) {
                writer.write("ID,Name,Age,Marks\n");
                writer.write("101,Anand,21,85.5\n");
                writer.write("102,Anshika,22,78.0\n");
                writer.write("103,Aakrati,23,90.2\n");
                writer.write("101,Ankit,21,85.5\n");
                writer.write("104,Muskan,20,88.5\n");
                writer.write("105,Avinash,21,76.3\n");
                writer.write("103,Aman,23,90.2\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Test
        public void testDetectDuplicates() {
            createTestCSV();  // Create the test CSV file
            DetectDuplicatesCSV.detectDuplicates(testFilePath);  // Run the detection logic


        }

        // Clean up after tests
        @Test
        public void testCleanup() {
            File file = new File(testFilePath);
            if (file.exists()) {
                assertTrue(file.delete(), "Failed to delete test file.");
            }
        }
    }
