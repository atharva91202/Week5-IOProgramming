package com.ioprogramming.Day1_CSVHandling.intermediateproblems;
import java.io.*;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {
        String path = "C:\\my doucments\\file\\csvread.csv";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name to Search");
        String getName = sc.nextLine().trim();

        boolean found = false;

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = reader.readLine();
           while ((line = reader.readLine())!=null){
            String [] cols = line.split(",");

            if (cols.length<4) continue;
            String Id = cols[0].trim();
            String name = cols[1].trim();
            String department = cols[2].trim();
            String salary = cols[3].trim();
            if (name.equalsIgnoreCase(getName)){
                System.out.println("Employee found");
                System.out.println("ID " + Id);
                System.out.println("Department " + department);
                System.out.println("Salary " +salary);
                found = true;
                break;
            }
           }if (!found){
                System.out.println("Employee not found");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
