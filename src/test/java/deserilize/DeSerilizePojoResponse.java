package deserilize;
import static io.restassured.RestAssured.*;

import io.restassured.parsing.Parser;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojoDesirilize.ApiAutomation;
import pojoDesirilize.CourseDetailPojo;

import java.util.List;
// To run this test please enable json server on local

public class DeSerilizePojoResponse {

    @Test
    public void testResponse(){
        CourseDetailPojo pojo=given().baseUri("http://localhost:3000/").expect()
                .defaultParser(Parser.JSON)
                .when().get("/courseContent").as(CourseDetailPojo.class);
       /* String  name= pojo.getInstructor();
        Assert.assertEquals(name, "saurav");*/
        System.out.println("instructor name is "+pojo.getInstructor());
        System.out.println("web automation course title is "+pojo.getCourse().getWebAutomation().get(1).getCourseTitle());
       //List<ApiAutomation> de= pojo.getCourse().getApiAutomation();
        List<ApiAutomation> apiCourses=pojo.getCourse().getApiAutomation();
        for(int i=0;i<apiCourses.size();i++){
            if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("Learn Automation by rahul shetty"));
       int price= apiCourses.get(i).getPrice();
            System.out.println("price is "+price);
            break;
        }

    }
}
