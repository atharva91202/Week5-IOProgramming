package com.ioprogramming.Day1_CSVHandling.advancedproblems.csvdataobjects;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


class CSVToStudentTest {

        private static final String TEST_CSV_FILE = "C:\\my doucments\\files\\updatedemployee.csv";

        @Test
        public void testReadCSV() throws IOException {
            createTestCSV();
            List<Student> students = CSVToStudent.readCSV(TEST_CSV_FILE);
            assertEquals(3, students.size()); // Expecting 3 valid records
        }

        private void createTestCSV() throws IOException {
            try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
                writer.println("ID,Name,Age,Marks");
                writer.println("101,Anand,21,85.5");
                writer.println("102,Ankit,22,invalid"); // Invalid marks
                writer.println("103,Avinash,23,90.2");
                writer.println("104,Anshika,20,88.5");
            }
        }
    }
