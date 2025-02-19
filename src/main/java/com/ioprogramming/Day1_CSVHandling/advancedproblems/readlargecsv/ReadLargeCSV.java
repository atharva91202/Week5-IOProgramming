package com.ioprogramming.Day1_CSVHandling.advancedproblems.readlargecsv;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {

    private static final int CHUNK_SIZE = 100;  // Process 100 lines at a time

    public static void readCSVInChunks(String filePath) {
        int totalRecordsProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int chunkCount = 0;

            while ((line = br.readLine()) != null) {
                chunkCount++;

                if (chunkCount % CHUNK_SIZE == 0) {
                    totalRecordsProcessed += CHUNK_SIZE;
                    System.out.println("Processed " + totalRecordsProcessed + " records.");
                }
            }

            if (chunkCount % CHUNK_SIZE != 0) {
                totalRecordsProcessed += chunkCount % CHUNK_SIZE;
                System.out.println("Processed " + totalRecordsProcessed + " records.");
            }

        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "E:/Capg/Week5_IO_Programming/Day1/src/main/resources/largefile.csv";  // Path to the large CSV file
        readCSVInChunks(filePath);
    }
}
