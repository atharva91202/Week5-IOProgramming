package com.ioprogramming.practiseproblems.jsonarray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
 class Student {
    private String name;
    private int id;
    private int age;

    // Constructor
    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


public class ListToJsonArray {

        public static void main(String[] args) throws JsonProcessingException {
            // Create a list of Student objects
            List<Student> students = new ArrayList<>();
            students.add(new Student("John Doe", 101, 20));
            students.add(new Student("Jane Smith", 102, 22));
            students.add(new Student("Alice Johnson", 103, 19));
            students.add(new Student("Bob Brown", 104, 21));

            // Convert list to JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(students);

            // Print JSON Array
            System.out.println("JSON Array:");
            System.out.println(jsonArray);
        }
    }
