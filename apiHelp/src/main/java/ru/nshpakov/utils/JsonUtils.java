package ru.nshpakov.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.nshpakov.dto.CourseDto;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static String asString(Object object) {
        // JSON в виде строки
        String s = "";
        try {
            s = new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            e.getMessage();
        }
        return s;
    }

    public static Object toObject(String json, Class class_) {
        // Десериализация JSON
        Object object = null;
        try {
            object = new ObjectMapper().readValue(new StringReader(json), class_);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static <T> List toListObjects(String jsonArrayObjects, T t) {
        // Десериализация JSON массива объектов в List
        List<T> lstObjects = new ArrayList<>();
        try {
            lstObjects = new ObjectMapper().readValue(jsonArrayObjects, new TypeReference<List<T>>() {
            });
            lstObjects.add(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lstObjects;
    }
}
