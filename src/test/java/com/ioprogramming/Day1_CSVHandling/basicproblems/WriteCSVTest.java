package com.ioprogramming.Day1_CSVHandling.basicproblems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class WriteCSVTest {
    private final String path = "C:\\my documents\\file\\csvread.csv";
    private final String expectedContent = "ID,Name,Department,Salary\n" +
            "101,Ram,Intern,15000\n" +
            "102,Shyam,IT,28000\n" +
            "103,Mohan,Devops,40000\n" +
            "104,Subhash,Testing,25000\n" +
            "105,Aman,HR,30000\n";

    @BeforeEach
    void setUp() {
        WriteCSV.main(new String[]{});
    }

    @Test
    void testCSVFileExists() {
        File file = new File(path);
        assertTrue(file.exists(), "CSV file should exist after execution");
    }

    @Test
    void testCSVFileContent() {
        StringBuilder actualContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                actualContent.append(line).append("\n");
            }
        } catch (IOException e) {
            fail("Exception while reading the CSV file: " + e.getMessage());
        }
        assertEquals(expectedContent, actualContent.toString(), "CSV content should match expected content");
    }

    @AfterEach
    void tearDown() {
        File file = new File(path);
        if (file.exists()) {
            assertTrue(file.delete(), "Temporary CSV file should be deleted after test");
        }
    }
}
