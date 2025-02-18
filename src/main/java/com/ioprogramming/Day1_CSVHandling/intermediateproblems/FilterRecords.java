package com.ioprogramming.Day1_CSVHandling.intermediateproblems;
import java.io.*;

public class FilterRecords {
    public static void main(String[] args) {
        String path = "C:\\my doucments\\file\\studentrecord.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine(); // Read and ignore header row
            System.out.println("ID, Name, Marks");

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                // Ensure the row has valid data
                if (columns.length < 3) continue;

                int marks = Integer.parseInt(columns[2].trim());

                if (marks > 80) {
                    System.out.println(columns[0] + ", " + columns[1] + ", " + marks);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
