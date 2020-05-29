package com.jackson.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.*;

public class Deserialize {

    /**
     * Simply Converting string to java object
     **/
    @Test
    public void MyCarsTest() {
        ObjectMapper objmapper = new ObjectMapper();

        String car = "{ \"brand\" : \"Tata\", \"doors\" : 5}";

        try {
            Car c = objmapper.readValue(car, Car.class);

            System.out.println("Converting JSON string to java object");
            System.out.println("Car Brand: " + c.getBrand());
            System.out.println("Car Doors: " + c.getDoors());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converting String to Reader and then passing it to object mapper to java object
     */
    @Test
    public void MyCarsTestReader() {
        ObjectMapper objmapper = new ObjectMapper();

        String car = "{ \"brand\" : \"Hyundai\", \"doors\" : 5}";

        Reader reader = new StringReader(car);

        try {
            Car c = objmapper.readValue(reader, Car.class);

            System.out.println("Converting JSON String to java object using Reader");
            System.out.println("Car Brand: " + c.getBrand());
            System.out.println("Car Doors: " + c.getDoors());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converting JSONFile to java object using File
     */
    @Test
    public void MyCarsTestUsingFile() {
        ObjectMapper objmapper = new ObjectMapper();

        File file = new File(System.getProperty("user.dir") + "/src/test/resources/first.json");

        try {
            Car c = objmapper.readValue(file, Car.class);

            System.out.println("Converting JSONFile to java object using File");
            System.out.println("Car Brand: " + c.getBrand());
            System.out.println("Car Doors: " + c.getDoors());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converting JSONFile to java object using InputStream
     */
    @Test
    public void MyCarsTestUsingInputStream() {
        ObjectMapper objmapper = new ObjectMapper();

        try {
            InputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/first.json");
            Car c = objmapper.readValue(file, Car.class);

            System.out.println("Converting JSONFile to java object using InputStream");
            System.out.println("Car Brand: " + c.getBrand());
            System.out.println("Car Doors: " + c.getDoors());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}