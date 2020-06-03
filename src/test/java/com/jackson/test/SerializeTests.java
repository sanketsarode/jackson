package com.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerializeTests {

    Car car = new Car();
    Transaction transaction = new Transaction();
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

    @Test
    public void serializeTestsWithDate() {
        System.out.println("Serialize java object containing date as long");

        try {
            transaction.setType("Success");
            transaction.setDate(new Date());
            System.out.println(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(transaction));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void serializeTestsWithDateAsString() {
        System.out.println("Serialize java object containing date as String");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objMapper.setDateFormat(simpleDateFormat);

        try {
            transaction.setType("Success");
            transaction.setDate(new Date());
            System.out.println(objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(transaction));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}