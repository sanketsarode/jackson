package com.jackson.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class JacksonTreeModel {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void treeModelJsonNode() {

        String car =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "\"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "\"nestedObject\" : { \"field\" : \"value\" }}";

        try {
            JsonNode jsonNode = objectMapper.readValue(car, JsonNode.class);
            //JsonNode jsonNode = objectMapper.readTree(car);

            System.out.println("Using JsonNode Jackson Tree Model Class to Deserialize the JSON String");
            System.out.println("Car Brand: " + jsonNode.get("brand"));
            System.out.println("Car Doors: " + jsonNode.get("doors"));

            JsonNode owners = jsonNode.get("owners");
            System.out.println("Owners: " + owners.get(0) + " , " + owners.get(1) + " , " + owners.get(2));

            JsonNode nestedObj = jsonNode.get("nestedObject");
            System.out.println("Field: " + nestedObj.get("field"));

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void convertJavaObjectToJsonNode() {
        Car car = new Car("MG", 5);

        try {
            JsonNode jsonNode = objectMapper.valueToTree(car);

            System.out.println("Convert Java Object To JsonNode");
            System.out.println("Car Brand: " + jsonNode.get("brand"));
            System.out.println("Car Doors: " + jsonNode.get("doors"));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}