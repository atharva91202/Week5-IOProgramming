package com.ioprogramming.Day1_CSVHandling.basicproblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCount {
    public static void main(String[] args) {
        String path ="C:\\my doucments\\file\\csvread.csv";
        int count = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while ((line = br.readLine())!=null){
                count++;
            }
            System.out.println("Total records are " + count);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
