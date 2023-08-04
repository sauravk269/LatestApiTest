package eCommerce;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.List;

import static  io.restassured.RestAssured.*;
public class AddItemsToShoppingCart {
// First check all items in shopping cart if
    // item already added delete it  and then add new item
Boolean flag= false;

List<Integer> bookId;
@Test
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
        JsonPath js = new JsonPath(response.asString());
        int count= js.getInt("book.size()");
    System.out.println("count is "+count);
    for(int i =0; i<count;i++) {
     int idNumber= js.getInt("..book.author");
        System.out.println(idNumber);
    }
    System.out.println("book id in list is "+bookId);
    }

    public void deleteItems(){
    if(flag==false){

    }
    }
    public void addItem(ITestContext context){
        given().baseUri("https://bookcart.azurewebsites.net/api/ShoppingCart/")
                .when().post("/AddToCart/"+context.getAttribute("userId"))
                .then();
    }
}
