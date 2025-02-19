package com.ioprogramming.practiseproblems.jsonstudentobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testStudentSerialization() throws Exception {
        // Arrange
        Student student = new Student("Rachin Ravindra", 27, List.of("Maths", "English", "Science", "Social Science"));
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJson = objectMapper.writeValueAsString(student);

        // Act
        String actualJson = student.toJson();

        // Assert
        assertEquals(expectedJson, actualJson, "Serialized JSON should match expected JSON");
    }

    @Test
    void testStudentFields() {
        // Arrange
        Student student = new Student("John Doe", 22, List.of("Physics", "Chemistry"));

        // Assert
        assertEquals("John Doe", student.getName(), "Name should be John Doe");
        assertEquals(22, student.getAge(), "Age should be 22");
        assertEquals(List.of("Physics", "Chemistry"), student.getSubjects(), "Subjects should match expected list");
    }
}