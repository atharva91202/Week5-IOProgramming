package com.ioprogramming.practiseproblems.mergejson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        //String to be merged
        String json1 ="{\"name\": \"John Doe\", \"age\": 30}";
        String json2 ="{\"email\": \"johndoe@gmail.com\", \"Location\": \"Bhopal\"}";

        //parse string to JSON node
        JsonNode node1 = objectMapper.readTree(json1);
        JsonNode node2 = objectMapper.readTree(json2);

        //Convert to objectNode to allow modification
        ObjectNode mergeNode = (ObjectNode) node1;
        mergeNode.setAll((ObjectNode) node2);

        String mergedJson = objectMapper.writeValueAsString(mergeNode);
        System.out.println("Merged JSON" + mergedJson);
    }
}
