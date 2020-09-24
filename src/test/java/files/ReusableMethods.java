package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

    public static JsonPath rawToJson (String response) {
        JsonPath getPlaceResponse_jsp = new JsonPath(response);
        return getPlaceResponse_jsp;
    }

}
