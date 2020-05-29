package com.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class TestCars {

    @Test
    public void MyCarsTest() {
        ObjectMapper objmapper = new ObjectMapper();

        String car = "{ \"brand\" : \"Tata\", \"doors\" : 5}";

        try {
            Car c = objmapper.readValue(car, Car.class);

            System.out.println("Car Brand: " + c.getBrand());
            System.out.println("Car Doors: " + c.getDoors());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}