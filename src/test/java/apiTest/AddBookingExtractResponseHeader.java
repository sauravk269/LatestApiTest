package apiTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
public class AddBookingExtractResponseHeader {

@Test
    public void addBookingDetails(){
    File file = new File("src/main/resources/BookingPayload.json");
        Response res=given().baseUri("https://restful-booker.herokuapp.com").body(file)
                .when().contentType(ContentType.JSON).post("/booking")
                .then().assertThat().statusCode(200).extract().response();
    System.out.println(res.asString());
    }
}
