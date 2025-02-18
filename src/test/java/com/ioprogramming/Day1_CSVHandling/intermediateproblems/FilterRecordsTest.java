package com.ioprogramming.Day1_CSVHandling.intermediateproblems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterRecordsTest {
    private final String path = "C:\\my documents\\file\\students.csv";
    private final String testContent = "ID,Name,Marks\n" +
            "101,Alice,78\n" +
            "102,Bob,85\n" +
            "103,Charlie,90\n" +
            "104,David,76\n" +
            "105,Eva,88\n";

    @BeforeEach
    void setUp() {
        try {
            File file = new File(path);
            file.getParentFile().mkdirs(); // Ensure the directory exists
            if (file.exists()) {
                file.delete(); // Delete old file if it exists
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(testContent);
            }
        } catch (IOException e) {
            fail("Failed to set up test CSV file: " + e.getMessage());
        }
    }

    @Test
    void testFilterCSV() {
        List<String> expectedRecords = List.of(
                "102, Bob, 85",
                "103, Charlie, 90",
                "105, Eva, 88"
        );

        List<String> actualRecords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine(); // Skip header row
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 3) continue;

                int marks = Integer.parseInt(columns[2].trim());
                if (marks > 80) {
                    actualRecords.add(columns[0] + ", " + columns[1] + ", " + marks);
                }
            }
        } catch (IOException | NumberFormatException e) {
            fail("Exception while reading the CSV file: " + e.getMessage());
        }

        assertEquals(expectedRecords, actualRecords, "Filtered records should match expected records");
    }

    @AfterEach
    void tearDown() {
        File file = new File(path);
        if (file.exists()) {
            assertTrue(file.delete(), "Temporary CSV file should be deleted after test");
        }
    }
}