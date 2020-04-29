package com.example.product.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object){

        try{
            return objectMapper.writeValueAsString(object);

        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }


}
