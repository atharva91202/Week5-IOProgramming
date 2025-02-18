package com.ioprogramming.Day1_CSVHandling.basicproblems;
import java.io.*;

public class ReadCSV {
    public static void main(String[] args) {
        String path = "C:\\my doucments\\file\\csvread.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line=reader.readLine())!=null){
                String[] columns = line.split(",");
                System.out.println(columns[0] +" "+  columns[1]  +" "+columns[2] +" "+ columns[3]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
