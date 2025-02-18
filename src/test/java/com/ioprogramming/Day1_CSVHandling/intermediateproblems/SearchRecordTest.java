package com.ioprogramming.Day1_CSVHandling.intermediateproblems;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class SearchRecordTest {
    private final String path = "C:\\my documents\\file\\csvread.csv";
    private final String testContent = "ID,Name,Department,Salary\n" +
            "101,Ram,Intern,15000\n" +
            "102,Shyam,IT,28000\n" +
            "103,Mohan,Devops,40000\n" +
            "104,Subhash,Testing,25000\n" +
            "105,Aman,HR,30000\n";

    @BeforeEach
    void setUp() {
        try {
            File file = new File(path);
            file.getParentFile().mkdirs(); // Ensure directory exists
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
    void testEmployeeExists() {
        assertEquals("ID: 103\nDepartment: Devops\nSalary: 40000", searchEmployee("Mohan"));
        assertEquals("ID: 102\nDepartment: IT\nSalary: 28000", searchEmployee("Shyam"));
    }

    @Test
    void testEmployeeNotFound() {
        assertEquals("Employee not found.", searchEmployee("Ravi"));
    }

    @Test
    void testCaseInsensitiveSearch() {
        assertEquals("ID: 104\nDepartment: Testing\nSalary: 25000", searchEmployee("subhash")); // Lowercase input
    }

    @Test
    void testInvalidFilePath() {
        File invalidFile = new File("C:\\invalid\\path\\file.csv");
        assertFalse(invalidFile.exists(), "File should not exist for this test");
        assertEquals("Error reading the file.", searchEmployee("Ram", "C:\\invalid\\path\\file.csv"));
    }

    private String searchEmployee(String searchName) {
        return searchEmployee(searchName, path);
    }

    private String searchEmployee(String searchName, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip header row
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cols = line.split(",");
                if (cols.length < 4) continue;

                String Id = cols[0].trim();
                String name = cols[1].trim();
                String department = cols[2].trim();
                String salary = cols[3].trim();

                if (name.equalsIgnoreCase(searchName)) {
                    return "ID: " + Id + "\nDepartment: " + department + "\nSalary: " + salary;
                }
            }
        } catch (IOException e) {
            return "Error reading the file.";
        }
        return "Employee not found.";
    }

    @AfterEach
    void tearDown() {
        File file = new File(path);
        if (file.exists()) {
            assertTrue(file.delete(), "Temporary CSV file should be deleted after test");
        }
    }
}
