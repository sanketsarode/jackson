package com.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;
import org.msgpack.jackson.dataformat.MessagePackFactory;

public class MultipleDataFormat {

    @Test
    public void dataFormat_CBOR() {

        try {
            System.out.println("Data Format Using CBOR");

            Car car = new Car("Tata", 6);
            ObjectMapper objectMapper = new ObjectMapper(new CBORFactory());

            byte[] cborBytes = objectMapper.writeValueAsBytes(car);

            Car car1 = objectMapper.readValue(cborBytes, Car.class);
            System.out.println("Brand: " + car1.getBrand());
            System.out.println("Door: " + car1.getDoors());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dataFormat_MsgPack() {

        try {
            System.out.println("Data Format Using MsgPack");

            Car car = new Car("BMW", 2);
            ObjectMapper objectMapper = new ObjectMapper(new MessagePackFactory());

            byte[] cborBytes = objectMapper.writeValueAsBytes(car);

            Car car1 = objectMapper.readValue(cborBytes, Car.class);
            System.out.println("Brand: " + car1.getBrand());
            System.out.println("Door: " + car1.getDoors());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dataFormat_YAML() {

        try {
            System.out.println("Data Format Using YAML");

            Car car = new Car("Ford", 5);
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

            byte[] cborBytes = objectMapper.writeValueAsBytes(car);

            Car car1 = objectMapper.readValue(cborBytes, Car.class);
            System.out.println("Brand: " + car1.getBrand());
            System.out.println("Door: " + car1.getDoors());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}