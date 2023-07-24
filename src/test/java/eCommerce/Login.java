package eCommerce;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Login {
    public  String Token;
    public int userId;
@Test
public void LoginToECommerceSite(ITestContext context){
    HashMap<String,String> hm = new HashMap<String,String>();
    hm.put("username","sauravk123");
    hm.put("password","Asus@123");
    Response res = given().baseUri("https://bookcart.azurewebsites.net/api").body(hm)
            .when().contentType(ContentType.JSON).post("/Login")
            .then().assertThat().statusCode(200).extract().response();
    System.out.println(res.asString());
    JsonPath js= new JsonPath(res.asString());
    Token = js.getString("token");
    context.setAttribute("token", Token);
    System.out.println("Extracted Token: "+Token);
    userId=js.getInt("userDetails.userId");
    System.out.println("User id is "+userId);
    context.setAttribute("userId",userId);
}

}
