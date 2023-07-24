package eCommerce;
import io.restassured.response.Response;
import org.testng.ITestContext;

import static  io.restassured.RestAssured.*;
public class AddItemsToShoppingCart {
// First check all items in shopping cart if
    // item already added delete it  and then add new item
Boolean flag= false;
    public void getCartItems(ITestContext context) {
        String path = "https://bookcart.azurewebsites.net/api" + "/ShoppingCart/" + context.getAttribute("userId");
        System.out.println("path is " + path);
        Response response = given().baseUri("https://bookcart.azurewebsites.net/api").when().
                get("/ShoppingCart/" + context.getAttribute("userId"))
                .then().assertThat().statusCode(200).extract().response();
        System.out.println("response is " + response.asString());
        if(response.asString().equals("[]")){
            flag=true;
        }
    }
    public void deleteItems(){

    }
    public void addItem(ITestContext context){
        given().baseUri("https://bookcart.azurewebsites.net/api/ShoppingCart/")
                .when().post("/AddToCart/"+context.getAttribute("userId"))
                .then();
    }
}
