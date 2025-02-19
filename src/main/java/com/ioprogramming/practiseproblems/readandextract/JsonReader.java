package com.ioprogramming.practiseproblems.readandextract;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReader {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\CG\\Week05-IOProgramming\\src\\data.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);

        String name = jsonNode.get("name").asText();
        String email = jsonNode.get("email").asText();

        System.out.println("Name : " + name);
        System.out.println("Email : " + email);
    }

}
