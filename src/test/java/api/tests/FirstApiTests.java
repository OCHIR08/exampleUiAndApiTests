package api.tests;

import api.models.PathchPostRequest;
import api.models.PostRequest;
import api.models.UpdatePostRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class FirstApiTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    // CREATE - POST
    @Test
    public void createPostTest() {
        PostRequest requestBody = new PostRequest();
        requestBody.setTitle("New Post");
        requestBody.setBody("This is a new post");
        requestBody.setUserId(1);

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
        UpdatePostRequest requestBody = new UpdatePostRequest();
        requestBody.setId(1);
        requestBody.setTitle("Updated Post");
        requestBody.setBody("This post has been updated");
        requestBody.setUserId(1);

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
        PathchPostRequest requestBody = new PathchPostRequest();
        requestBody.setTitle("Partially Updated Title");

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
