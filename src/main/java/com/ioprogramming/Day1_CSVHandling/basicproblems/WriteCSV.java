package com.ioprogramming.Day1_CSVHandling.basicproblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String path ="\\C:\\my doucments\\file\\csvread.csv\\";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            writer.write("ID,Name,Department,Salary\n");
            writer.write("101,Ram,Intern,15000\n");
            writer.write("102,Shyam,IT,28000\n");
            writer.write("103,Mohan,Devops,40000\n");
            writer.write("104,Subhash,Testing,25000\n");
            writer.write("105,Aman,HR,30000\n");

            System.out.println("CSV file Written Successfully");
        }catch (IOException e){
          e.printStackTrace();
        }
    }
}

