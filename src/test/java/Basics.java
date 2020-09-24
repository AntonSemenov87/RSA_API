import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {
    public static void main(String[] args) {

        // Validate is ADD_place API is working as expected

        // given --> all input details
        // when --> submit the API - resource, http method
        // then --> validate response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response =
                given()//.log().all()
                        .queryParam("key", "qaclick123")
                        .header("Content-Type", "application/json")
                        .body(Payload.addPlace())
                .when().post("maps/api/place/add/json")
                .then()//.log().all()
                        .assertThat().statusCode(200)
                        .body("scope", equalTo("APP"))
                        .header("Server", "Apache/2.4.18 (Ubuntu)")
                .extract()
                        .response().asString();

        System.out.println(response);

        JsonPath js = new JsonPath(response); // for parsing JSON
        String place_id = js.getString("place_id");
        System.out.println(place_id);




    }
}
