package com.ioprogramming.Day1_CSVHandling.basicproblems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ReadCSVTest {
    private final String path = "C:\\my documents\\file\\csvread.csv";
    private final String testContent = "ID,Name,Department,Salary\n" +
            "101,Ram,Intern,15000\n" +
            "102,Shyam,IT,28000\n" +
            "103,Mohan,Devops,40000\n" +
            "104,Subhash,Testing,25000\n" +
            "105,Aman,HR,30000\n";

    @BeforeEach
    void setUp() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(testContent);
        } catch (IOException e) {
            fail("Failed to set up test CSV file: " + e.getMessage());
        }
    }

    @Test
    void testCSVFileReading() {
        StringBuilder actualContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                actualContent.append(line).append("\n");
            }
        } catch (IOException e) {
            fail("Exception while reading the CSV file: " + e.getMessage());
        }
        assertEquals(testContent.trim(), actualContent.toString().trim(), "CSV file content should match expected content");
    }

    @AfterEach
    void tearDown() {
        File file = new File(path);
        if (file.exists()) {
            assertTrue(file.delete(), "Temporary CSV file should be deleted after test");
        }
    }
}
