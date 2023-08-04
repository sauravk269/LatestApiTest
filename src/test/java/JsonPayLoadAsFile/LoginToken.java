package JsonPayLoadAsFile;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;

import static  io.restassured.RestAssured.*;
public class LoginToken {
@Test
    public void getToken(ITestContext context){
        File file = new File("src/main/resources/TokenGenerator.json");
        Response res=given().baseUri("https://restful-booker.herokuapp.com").contentType(ContentType.JSON)
                .body(file).when().post("/auth").then().extract().response();
    JsonPath js = new JsonPath(res.asString());
    String tokenId= js.getString("token");
    System.out.println("Token id is "+tokenId);
    context.setAttribute("token", tokenId);
    //context.setAttribute("cartAttribute", ca);
    }
}
