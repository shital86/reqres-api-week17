package com.studentapp.reqresinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ReqresDelete extends TestBase {
    @Test
    public void deleteUser(){
        Response response=given()
                .pathParam("id",234)
                .when()
                .delete("/users/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }

}
