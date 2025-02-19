package com.ioprogramming.Day1_CSVHandling.advancedproblems.encryptdecrypt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncryptDecryptCSVTest {
    private static final String CSV_PATH = "C:\\my doucments\\files\\encryt_data.csv";

    @BeforeEach
    void setUp() {
        EncryptDecryptCSV.writeEncryptedCSV();
    }

    @Test
    void testCSVFileExists() {
        File file = new File(CSV_PATH);
        assertTrue(file.exists(), "Encrypted CSV file should exist.");
    }

    @Test
    void testDecryption() {
        EncryptDecryptCSV.readDecryptedCSV(); // Run decryption method
        try {
            List<String> lines = Files.readAllLines(Paths.get(CSV_PATH));
            assertEquals(6, lines.size(), "CSV should have header + 5 data rows");
        } catch (IOException e) {
            fail("Error reading encrypted CSV file.");
        }
    }

    @AfterEach
    void tearDown() {
        File file = new File(CSV_PATH);
        if (file.exists()) {
            assertTrue(file.delete(), "Encrypted CSV file should be deleted after tests.");
        }
    }
}