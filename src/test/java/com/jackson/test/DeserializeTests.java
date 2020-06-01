package com.jackson.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.Map;

public class DeserializeTests {

    ObjectMapper objmapper = new ObjectMapper();
    String car = null;

    /**
     * Simply Converting string to java object
     **/
    @Test
    public void MyCarsTest() {

        car = "{ \"brand\" : \"Tata\", \"doors\" : 5}";

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

        car = "{ \"brand\" : \"Hyundai\", \"doors\" : 5}";

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

    /**
     * Converting JSON String to java array object
     */
    @Test
    public void MyCarsTestJSONArrayString() {
        car = "[{ \"brand\" : \"Fiat\", \"doors\" : 4},{ \"brand\" : \"Kia\", \"doors\" : 5}]";

        try {
            Car[] c = objmapper.readValue(car, Car[].class);

            System.out.println("Converting JSON string to java array object");
            for (Car s : c) {
                System.out.println("Car Brand: " + s.getBrand());
                System.out.println("Car Doors: " + s.getDoors());
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converting JSON String to java list object
     */
    @Test
    public void MyCarsTestJSONListString() {
        car = "[{ \"brand\" : \"Kia\", \"doors\" : 4},{ \"brand\" : \"Fiat\", \"doors\" : 5}]";

        try {
            List<Car> c = objmapper.readValue(car, new TypeReference<List<Car>>() {
            });

            System.out.println("Converting JSON string to java list object");
            for (Car s : c) {
                System.out.println("Car Brand: " + s.getBrand());
                System.out.println("Car Doors: " + s.getDoors());
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converting JSON String to java Map Object
     */
    @Test
    public void MyCarsTestJSONMapObject() {
        car = "{ \"brand\" : \"Hyundai\", \"doors\" : 5}";

        try {
            Map<String, Object> c = objmapper.readValue(car, new TypeReference<Map<String, Object>>() {
            });

            System.out.println("Converting JSON string to java map object");
            System.out.println("Car Brand: " + c.get("brand"));
            System.out.println("Car Doors: " + c.get("doors"));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Configure object mapper to handle null values in JSON for primitive data types in Java
     */
    @Test
    public void handlingNullObjectMapperPrimitiveDataTypes() {
        car = "{\"brand\" : \"Hyundai\", \"doors\" : null}";
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        try {
            Car c = objMapper.readValue(car, Car.class);

            System.out.println("Handling Null properties in JSON");
            System.out.println("Car Brand: " + c.getBrand());
            System.out.println("Car Doors: " + c.getDoors());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Configure object mapper to handle unknown properties in JSON
     */
    @Test
    public void handlingUnknownObjectMapperPrimitiveDataTypes() {
        car = "{\"brand\" : \"Hyundai\", \"doors\" : 5, \"type\" : \"Compact\"}";
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            Car c = objMapper.readValue(car, Car.class);

            System.out.println("Handling unknown properties in JSON");
            System.out.println("Car Brand: " + c.getBrand());
            System.out.println("Car Doors: " + c.getDoors());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
