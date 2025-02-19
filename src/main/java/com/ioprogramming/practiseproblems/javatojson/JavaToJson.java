package com.ioprogramming.practiseproblems.javatojson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJson {
    String brandName;
    int modelNo;
    int year;
    public JavaToJson(String brandName , int modelNo , int year){
        this.brandName = brandName;
        this.modelNo = modelNo;
        this.year=year;
    }
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getModelNo() {
        return modelNo;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

public String toJson() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(this);
}

    public static void main(String[] args) throws JsonProcessingException {
        JavaToJson car = new JavaToJson("Morris Garages",1000293,2022);
        System.out.println(car.toJson());
    }

}
