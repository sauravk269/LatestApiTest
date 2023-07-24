package eCommerce;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCartDetails {
    Boolean flag= false;
@Test
    public void getCartItems(ITestContext context){
    String path= "https://bookcart.azurewebsites.net/api"+"/ShoppingCart/"+context.getAttribute("userId");
    System.out.println("path is "+path);
        Response response = given().baseUri("https://bookcart.azurewebsites.net/api").when().
                get("/ShoppingCart/"+context.getAttribute("userId"))
                .then().assertThat().statusCode(200).extract().response();
    System.out.println("response is "+response.asString());
if(response.asString().equals("[]")){
    System.out.println(" Array list is empty");
    flag=true;
}
    }@Test
    public void addItemsToCart(ITestContext context) {
        if (flag == true) {
            Response re= given().baseUri("https://bookcart.azurewebsites.net/api/ShoppingCart")
                    .when().post("/AddToCart/"+context.getAttribute("userId")+"/"+7)
                    .then().extract().response();
            System.out.println("Response is "+re.asString());
        }else {
            System.out.println("Cart is not empty");
        }

    }

    }
