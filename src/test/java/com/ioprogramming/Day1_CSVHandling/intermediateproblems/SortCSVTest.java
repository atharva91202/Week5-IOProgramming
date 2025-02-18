package com.ioprogramming.Day1_CSVHandling.intermediateproblems;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortCSVTest {
    private static final String TEST_CSV_FILE = "C:\\my doucments\\files\\updatedemployee.csv";;

    @Test
    public void testSortingBySalary() throws IOException {
        createTestCSV();

        List<String> lines = Files.readAllLines(Paths.get(TEST_CSV_FILE));
        assertTrue(lines.get(1).contains("Anand"));
    }

    private void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
            writer.println("ID,Name,Department,Salary");
            writer.println("101,Anand,HR,500000");
            writer.println("102,Avinash,IT,50000");
        }
    }
}