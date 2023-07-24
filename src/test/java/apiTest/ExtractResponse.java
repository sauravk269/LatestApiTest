package apiTest;
 import io.restassured.path.json.JsonPath;
 import io.restassured.response.Response;
 import org.testng.Assert;
 import static io.restassured.RestAssured.*;

public class ExtractResponse {

   @org.testng.annotations.Test
    public void verifyStatusCode(){
     given().baseUri("http://localhost:3000").when().get("/store")
        .then().log().all().assertThat().statusCode(200);
    }

    @org.testng.annotations.Test
    public void extractFirstBookAuthor(){
        Response response= given().baseUri("http://localhost:3000").when().get("/store")
                .then().extract().response();
     JsonPath js = new JsonPath(response.asString());
        String firstBookAuthor=  js.getString("book[0].author");
     System.out.println("Author received from First Book is "+firstBookAuthor);
     Assert.assertEquals(firstBookAuthor,"Nigel Rees");
    }
    @org.testng.annotations.Test
    public void extractAllBookAuthor(){
        Response response= given().baseUri("http://localhost:3000").when().get("/store")
                .then().extract().response();
        JsonPath js= new JsonPath(response.asString());
        int bookCount= js.getInt("book.size()");
        System.out.println("Count of book is "+bookCount);
        for( int i=0;i<bookCount;i++){
            String allBookAuthor = js.get("book["+i+"].author");
            System.out.println("Authors of "+ i+" book is "+allBookAuthor);
        }
    }
    @org.testng.annotations.Test
    public void FindAuthorIfTitleContainsSpecificValue(){
        Response response= given().baseUri("http://localhost:3000").when().get("/store")
                .then().extract().response();
        JsonPath js= new JsonPath(response.asString());
        int bookCount= js.getInt("book.size()");
        System.out.println(bookCount);
        for (int j=0;j<bookCount;j++){
            String title= js.getString("book["+j+"].title");
            if(title.equalsIgnoreCase("Sword of Honour")){
                String author = js.getString("book["+j+"].author");
                System.out.println("Author name for tile Sword of Honour is "+author);
                break;
            }
        }
    }

}
