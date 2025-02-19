package com.ioprogramming.practiseproblems.jsonstudentobject;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private List<String> subjects;

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Student(){

    }
    public Student(String name,int age,List<String> subjects){
        this.name=name;
        this.age=age;
        this.subjects=subjects;
    }
    public String toJson() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student("Rachin Ravindra",27,List.of("Maths","English","Science","Social Science"));
        System.out.println(student.toJson());
    }
}
