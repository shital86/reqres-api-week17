package com.studentapp.reqresinfo;

import com.studentapp.model.ReqresPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReqresPost extends TestBase {
    @Test
    public void createNewUser(){
        ReqresPojo reqresPojo=new ReqresPojo();
        reqresPojo.setJob("Automation Tester");
        reqresPojo.setName("Kim");
        Response response = given()
                .header("Content-Type","application/json")
                .body(reqresPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();

    }
    @Test
    public void loginSuccessfully(){
        ReqresPojo reqresPojo=new ReqresPojo();
        reqresPojo.setEmail("eve.holt@reqres.in");
        reqresPojo.setPassword("cityslicka");

        Response response=given()
                .header("Content-Type","application/json")
                .body(reqresPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
