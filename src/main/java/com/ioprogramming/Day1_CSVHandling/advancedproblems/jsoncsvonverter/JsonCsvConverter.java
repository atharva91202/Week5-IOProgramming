package com.ioprogramming.Day1_CSVHandling.advancedproblems.jsoncsvonverter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.util.*;

public class JsonCsvConverter {
private static final String JSON_Path = "C:\\CG\\Week05-IOProgramming\\src\\students.json";
private static final String CSV_Path ="C:\\my doucments\\files\\students.csv";

    public static void main(String[] args) {
        convertJsonToCsv();
        convertCsvToJson();
    }

    // Convert JSON to CSV
    public static void convertJsonToCsv() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> students = objectMapper.readValue(new File(JSON_Path), new TypeReference<List<Map<String, Object>>>() {});

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_Path))) {
                // Write CSV Header
                writer.write("ID,Name,Department,Marks\n");

                // Write Data Rows
                for (Map<String, Object> student : students) {
                    writer.write(student.get("ID") + "," + student.get("Name") + "," + student.get("Department") + "," + student.get("Marks") + "\n");
                }
            }
            System.out.println("JSON successfully converted to CSV.");
        } catch (IOException e) {
            System.err.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }

    // Convert CSV to JSON
    public static void convertCsvToJson() {
        List<Map<String, Object>> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_Path))) {
            String headerLine = reader.readLine(); // Read header
            String[] headers = headerLine.split(",");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, Object> student = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    student.put(headers[i], values[i]);
                }
                students.add(student);
            }

            // Convert to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(JSON_Path), students);

            System.out.println("CSV successfully converted to JSON.");
        } catch (IOException e) {
            System.err.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
}