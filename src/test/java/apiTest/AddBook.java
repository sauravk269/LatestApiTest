package apiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class AddBook {
    @Test
    public void addBookDepoDetails() {
        File file = new File("src/main/resources/BookDepoPayLoad.json");
        Response res = given().baseUri("http://localhost:3000/store").body(file)
                .when().contentType(ContentType.JSON).post("/book")
                .then().assertThat().statusCode(201).extract().response();
        System.out.println(res.asString());

    }
}
