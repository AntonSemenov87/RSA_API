import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {
    public static void main(String[] args) {

        // Validate is ADD_place API is working as expected

        // given --> all input details
        // when --> submit the API - resource, http method
        // then --> validate response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"location\": {\n" +
                        "        \"lat\": -38.383494,\n" +
                        "        \"lng\": 33.427362\n" +
                        "    },\n" +
                        "    \"accuracy\": 50,\n" +
                        "    \"name\": \"Johny House\",\n" +
                        "    \"phone_number\": \"+1(773) 999 1111\",\n" +
                        "    \"address\": \"21 W Scott Str, Miller Park, IL 60703\",\n" +
                        "    \"types\": [\n" +
                        "        \"Shoe Park\",\n" +
                        "        \"Shop\"\n" +
                        "    ],\n" +
                        "    \"website\": \"http://mypark.com\",\n" +
                        "    \"language\": \"French-IN\"\n" +
                        "}")
                .when().post("maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                        .body("scope", equalTo("APP"))
                        .header("Server", "Apache/2.4.18 (Ubuntu)");


    }
}
