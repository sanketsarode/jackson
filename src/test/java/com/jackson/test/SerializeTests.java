package com.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.FileOutputStream;

public class SerializeTests {

    Car car = new Car();
    ObjectMapper objMapper = new ObjectMapper();

    @Test
    public void serializeTests() {
        System.out.println("Serializing java object to JSON File");

        try {
            car.setBrand("Mahindra");
            car.setDoors(6);
            objMapper.writeValue(new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/serializeJson.json"), car);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void serializeTestsAsString() {
        System.out.println("Serializing java object to JSON String");

        try {
            car.setBrand("Mahindra");
            car.setDoors(6);
            System.out.println(objMapper.writeValueAsString(car));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void serializeTestsAsStringPreetyPrint() {
        System.out.println("Serializing java object to JSON String in Pretty Print Format");

        try {
            car.setBrand("Ford");
            car.setDoors(6);
            System.out.println(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(car));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}