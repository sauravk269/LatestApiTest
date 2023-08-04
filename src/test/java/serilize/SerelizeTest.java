package serilize;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojoSerilize.AddPlace;
import pojoSerilize.AddLocation;

import java.util.ArrayList;
import java.util.List;

public class SerelizeTest {
    @Test
    public void serelizeData(){
    AddPlace place= new AddPlace();
    AddLocation location = new AddLocation();
     place.setAccuracy(45);
     place.setLanguage("german");
     place.setName("Huge");
     place.setAddress("Dublin MA");
     place.setPhone_number("90978978");
     place.setWebsite("http://google.com");
     List<String> li= new ArrayList<>();
     li.add("high");
     li.add("sez");
     li.add("railway");
      place.setTypes(li);
      location.setLat(-37.3490);
      location.setLongitude(38.6670);
      place.setLocation(location);
        Response res =given().baseUri("https://rahulshettyacademy.com")
                .queryParam("key", "qaclick123")
                .body(place).when()
                .post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();
        String responseString = res.asString();
        System.out.println(responseString);
    }

}
