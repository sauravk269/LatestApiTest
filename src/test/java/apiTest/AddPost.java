package apiTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class AddPost {

    @Test
    public void addPostData() {
        File file = new File("src/main/resources/data.json");
        Response res = given().baseUri("http://localhost:3000").body(file)
                .when().contentType(ContentType.JSON).post("/posts")
                .then().assertThat().statusCode(201).extract().response();
        System.out.println(res.asString());

    }
}
