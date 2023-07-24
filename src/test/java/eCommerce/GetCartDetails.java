package eCommerce;

import io.restassured.response.ResponseBody;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCartDetails {
@Test
    public void getCartItems(ITestContext context){
    String path= "https://bookcart.azurewebsites.net/api"+"/ShoppingCart/"+context.getAttribute("userId");
    System.out.println("path is "+path);
        ResponseBody response = given().baseUri("https://bookcart.azurewebsites.net/api").when().
                get("/ShoppingCart/"+context.getAttribute("userId"))
                .then().assertThat().statusCode(200).extract().response().body();
    System.out.println("response is "+response.asString());

    }
}
