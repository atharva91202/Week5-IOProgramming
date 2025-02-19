package com.ioprogramming.Day1_CSVHandling.advancedproblems.csvfromdatabase;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseToCSV {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/anand";
    private static final String USERNAME = "anandsoni992";
    private static final String PASSWORD = "Anand@1508";
    private static final String CSV_FILE_PATH = "C:\\my doucments\\files\\updatedemployee.csv";

    public static void exportToCSV() {
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             FileWriter csvWriter = new FileWriter(CSV_FILE_PATH)) {


            csvWriter.append("Employee ID,Name,Department,Salary\n");
            while (rs.next()) {
                csvWriter.append(rs.getString("employee_id")).append(",");
                csvWriter.append(rs.getString("name")).append(",");
                csvWriter.append(rs.getString("department")).append(",");
                csvWriter.append(rs.getString("salary")).append("\n");
            }

            System.out.println("CSV file generated successfully: " + CSV_FILE_PATH);

        } catch (SQLException | IOException e) {
            System.err.println("Error exporting data to CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        exportToCSV();
    }
}
