package com.ioprogramming.Day1_CSVHandling.advancedproblems.csvfromdatabase;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseToCSVTest {

    private final String testFilePath = "C:\\my doucments\\files\\updatedemployee.csv";

    @Test
    public void testCSVExport() {
        DatabaseToCSV.exportToCSV();
        File csvFile = new File(testFilePath);
        assertTrue(csvFile.exists(), "CSV file was not created.");
    }
}
