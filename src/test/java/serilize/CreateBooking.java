package serilize;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojoserilize2.BookingDetails;
import static io.restassured.RestAssured.*;
import pojoserilize2.BookingDates;
public class CreateBooking {

@Test
    public void bookTicket(){
        BookingDetails bookingdetails = new BookingDetails();
        BookingDates date = new BookingDates();
        bookingdetails.setFirstname("namSabana");
        bookingdetails.setLastname("kulkarni");
        bookingdetails.setTotalprice(90);
        bookingdetails.setAdditionalneeds("Dinner");
        bookingdetails.setDepositpaid(true);
        date.setCheckin("12/08/2023");
        date.setCheckout("22/08/2023");
        bookingdetails.setBookingdates(date);
        given().baseUri("https://restful-booker.herokuapp.com").body(bookingdetails)
                .contentType(ContentType.JSON)
                .when().post("/booking").then().log().all();
    }
}
