package tests;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllProducts {
    @Test
    public void testGetAllProducts() {
        RestAssured.baseURI = "http://localhost:3030";
        given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}