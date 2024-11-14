package tests;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class DeleteProduct {
    private String sku;
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://localhost:3030";
        sku = "12345";
        String newProductJson = "{"
                + "\"sku\": \"" + sku + "\","
                + "\"name\": \"Test Product\","
                + "\"type\": \"Electronics\","
                + "\"price\": 99.99,"
                + "\"shipping\": 5.00,"
                + "\"upc\": \"123456789012\","
                + "\"description\": \"A great test product for automation testing.\","
                + "\"manufacturer\": \"Test Manufacturer\","
                + "\"model\": \"TP-1234\","
                + "\"url\": \"http://example.com/test-product\","
                + "\"image\": \"http://example.com/images/test-product.jpg\""
                + "}";
        given()
                .contentType("application/json")
                .body(newProductJson)
                .when()
                .post("/products")
                .then()
                .statusCode(201);
    }
    @Test
    public void testDeleteProduct() {
        given()
                .pathParam("sku", sku)
                .when()
                .delete("/products/{sku}")
                .then()
                .statusCode(204);
        given()
                .pathParam("sku", sku)
                .when()
                .get("/products/{sku}")
                .then()
                .statusCode(404);
    }
}