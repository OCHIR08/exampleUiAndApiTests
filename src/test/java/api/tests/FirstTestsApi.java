package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class FirstTestsApi {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    // CREATE - POST
    @Test
    public void createPostTest() {
        String requestBody = """
                {
                    "title": "New Post",
                    "body": "This is a new post",
                    "userId": 1
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("New Post"))
                .body("body", equalTo("This is a new post"))
                .body("userId", equalTo(1));
    }

    // READ - GET
    @Test
    public void getPostTest() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

    // UPDATE - PUT
    @Test
    public void updatePostTest() {
        String requestBody = """
                {
                    "id": 1,
                    "title": "Updated Post",
                    "body": "This post has been updated",
                    "userId": 1
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParam("id", 1)
                .when()
                .put("/posts/{id}")
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated Post"))
                .body("body", equalTo("This post has been updated"));
    }

    // PATCH (частичное обновление)
    @Test
    public void patchPostTest() {
        String requestBody = """
                {
                    "title": "Partially Updated Title"
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .pathParam("id", 1)
                .when()
                .patch("/posts/{id}")
                .then()
                .statusCode(200)
                .body("title", equalTo("Partially Updated Title"));
    }

    // DELETE
    @Test
    public void deletePostTest() {
        given()
                .pathParam("id", 1)
                .when()
                .delete("/posts/{id}")
                .then()
                .statusCode(200);
    }

}
