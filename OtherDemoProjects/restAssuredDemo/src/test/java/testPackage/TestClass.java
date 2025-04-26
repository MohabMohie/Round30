package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class TestClass {

    @Test
    public void testMethod() {
        // Test logic here
        var response = get("https://catfact.ninja/breeds");

        var bodyAsString = response.asPrettyString();
        response.then()
                .body("total", equalTo(98));
    }

    @Test
    public void testMethod2() {
        get("https://catfact.ninja/breeds")
                .then()
                .body("data.breed", hasItems("Abyssinian", "Chausie", "Birman"));
    }

    @Test
    public void testMethod3() {
        when().
                get("https://catfact.ninja/breeds").
                then().
                statusCode(200).
                body("total", equalTo(980),
                        "data.breed", hasItems("Abyssinian"),
                        "data.breed", hasItems("Chausie"),
                        "data.breed", hasItems("Birman"),
                        "data.breed", hasItems("DUMMY"));
    }

    @Test
    public void testMethod4() {


        given().
        when().
                post("https://dummyjson.com/auth/login").
        then().
                statusCode(200);
    }

    @BeforeAll
    public static void setup() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void init() {
        System.out.println("BeforeEach");
    }
}
