package eCommerce;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class GetAllBookDetails {
    @Test
    public void GetAllBookDetails(){
        String responseHeader= given().baseUri("https://bookcart.azurewebsites.net/api").when().get("/Book")
                .then().log().all().assertThat().statusCode(200).extract().header("Content-Type");
        // Extract Response Header and add Assertion to response header
        System.out.println("Response Header is "+responseHeader);
        Assert.assertEquals(responseHeader,"application/json; charset=utf-8");
    }
    @Test
    // get all response header name and value
    public void getAllResponseHeader(){
      Headers responseHeader= given().baseUri("https://bookcart.azurewebsites.net/api")
                .when().get("/Book")
                .then().
                assertThat().statusCode(200).
                extract().headers();
      for(Header header: responseHeader){
          System.out.println("Header name is "+header.getName()+" and value is "+header.getValue());
      }
    }
}
