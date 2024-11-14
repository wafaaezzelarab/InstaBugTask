package tests;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateNewProduct {
    @Test
    public void testCreateProduct() {
        RestAssured.baseURI = "http://localhost:3030";
        // Define the product data
        String newProductJson = "{"
                + "\"sku\": \"12345\","
                + "\"name\": \"Test Product\","
                + "\"type\": \"Electronics\","
                + "\"price\": 99.99,"
                + "\"upc\": \"12345\","
                + "\"description\": \"A great test product for automation testing.\","
                + "\"model\": \"Product0123\","
                + "\"url\": \"http://example.com/test-product\","
                + "}";

        given()
                .contentType("application/json")
                .body(newProductJson)
                .when()
                .post("/products")
                .then()
                .statusCode(201)
                .body("name", equalTo("Test Product"));
        given()
                .pathParam("sku", "12345")
                .when()
                .get("/products/{sku}")
                .then()
                .statusCode(200)
                .body("name", equalTo("Test Product"));
    }
}

