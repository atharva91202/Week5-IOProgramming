package com.ioprogramming.Day1_CSVHandling.advancedproblems.jsoncsvonverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonCsvConverterTest {
    private static final String JSON_Path = "C:\\CG\\Week05-IOProgramming\\src\\students.json";
    private static final String CSV_Path ="C:\\my doucments\\files\\students.csv";
    @BeforeEach
    void setUp() {
        // Sample JSON Data for Testing
        String sampleJson = "[{\"ID\":101, \"Name\":\"Ram\", \"Department\":\"Intern\", \"Marks\":75}," +
                "{\"ID\":102, \"Name\":\"Shyam\", \"Department\":\"IT\", \"Marks\":85}," +
                "{\"ID\":103, \"Name\":\"Mohan\", \"Department\":\"DevOps\", \"Marks\":90}]";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_Path))) {
            writer.write(sampleJson);
        } catch (IOException e) {
            fail("Failed to create test JSON file.");
        }
    }

    @Test
    void testJsonToCsvConversion() {
        JsonCsvConverter.convertJsonToCsv();
        File csvFile = new File(CSV_Path);
        assertTrue(csvFile.exists(), "CSV file should be created");

        try {
            List<String> lines = Files.readAllLines(Paths.get(CSV_Path));
            assertEquals(4, lines.size(), "CSV should have header + 3 data rows");
        } catch (IOException e) {
            fail("Error reading CSV file.");
        }
    }

    @Test
    void testCsvToJsonConversion() {
        JsonCsvConverter.convertJsonToCsv(); // Ensure CSV exists
        JsonCsvConverter.convertCsvToJson(); // Convert back to JSON

        File jsonFile = new File(JSON_Path);
        assertTrue(jsonFile.exists(), "JSON file should be recreated");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> students = objectMapper.readValue(new File(JSON_Path), List.class);
            assertEquals(3, students.size(), "JSON should contain 3 students");
        } catch (IOException e) {
            fail("Error reading JSON file.");
        }
    }

    @AfterEach
    void tearDown() {
        new File(JSON_Path).delete();
        new File(CSV_Path).delete();
    }
}