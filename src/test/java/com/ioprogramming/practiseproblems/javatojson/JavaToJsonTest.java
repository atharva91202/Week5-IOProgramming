package com.ioprogramming.practiseproblems.javatojson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaToJsonTest {
    @Test
    void testJavaToJsonSerialization() throws JsonProcessingException {
        // Arrange
        JavaToJson car = new JavaToJson("Morris Garages", 1000293, 2022);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJson = objectMapper.writeValueAsString(car);

        // Act
        String actualJson = car.toJson();

        // Assert
        assertEquals(expectedJson, actualJson, "Serialized JSON should match expected JSON");
    }

    @Test
    void testJavaToJsonFields() {
        // Arrange
        JavaToJson car = new JavaToJson("Tesla", 2000456, 2023);

        // Assert
        assertEquals("Tesla", car.getBrandName(), "Brand name should be Tesla");
        assertEquals(2000456, car.getModelNo(), "Model number should be 2000456");
        assertEquals(2023, car.getYear(), "Year should be 2023");
    }
}
