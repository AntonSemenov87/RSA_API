package files;

public class Payload {

    public static String addPlace() {
        return "{\n" +
        "    \"location\": {\n" +
                "        \"lat\": -38.383494,\n" +
                "        \"lng\": 33.427362\n" +
                "    },\n" +
                "    \"accuracy\": 50,\n" +
                "    \"name\": \"Slava House\",\n" +
                "    \"phone_number\": \"+1(773) 999 1111\",\n" +
                "    \"address\": \"21 W Scott Str, Miller Park, IL 60703\",\n" +
                "    \"types\": [\n" +
                "        \"Shoe Park\",\n" +
                "        \"Shop\"\n" +
                "    ],\n" +
                "    \"website\": \"http://mypark.com\",\n" +
                "    \"language\": \"Ukrainian-UA\"\n" +
                "}";
    }

}
