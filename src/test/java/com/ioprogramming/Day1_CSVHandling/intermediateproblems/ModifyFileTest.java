package com.ioprogramming.Day1_CSVHandling.intermediateproblems;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModifyFileTest {
    private static final String TEST_INPUT_CSV = "C:\\my doucments\\files\\employee.csv";
    private static final String TEST_OUTPUT_CSV = "C:\\my doucments\\files\\updatedemployee.csv";

    @Test
    public void testSalaryUpdate() throws IOException {
        // Create a test CSV file
        createTestCSV();

        // Run the salary update function
        ModifyFile.updateSalaries(TEST_INPUT_CSV, TEST_OUTPUT_CSV);

        // Read the updated file and check IT employees' salaries
        List<String> lines = Files.readAllLines(Paths.get(TEST_OUTPUT_CSV));
        for (String line : lines) {
            if (line.contains("IT")) {
                String[] columns = line.split(",");
                double salary = Double.parseDouble(columns[3]);
                assertTrue(salary > 60000); // Previous IT salary was 60000
            }
        }
    }

    private void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_INPUT_CSV))) {
            writer.println("ID,Name,Department,Salary");
            writer.println("101,Anand,HR,50000");
            writer.println("102,Avinash,IT,60000");
            writer.println("103,Ankit,Finance,55000");
            writer.println("104,Anshika,IT,70000");
            writer.println("105,Aakrati,Sales,62000");
        }
    }
}
