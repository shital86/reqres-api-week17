package com.studentapp;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresExtraction {
    public static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://reqres.in/";
        response =given()
                .when()
                .get("/api/users?page=2")
                .then().statusCode(200);
    }
    @Test
    public void test() {
//Page=2
         int page=response.extract().path("page");
        System.out.println("Page : " + page);

        int per_page = response.extract().path("per_page");
        System.out.println("2. Per Page      :" + per_page);

        int id = response.extract().path("data[1].id");
        System.out.println("3. ID            :" + id);

        String first_name = response.extract().path("data[3].first_name");
        System.out.println("4. First Name    :" + first_name);

        List<String> listOfData = response.extract().path("data");
        System.out.println("5. List of Data  :" + listOfData.size());

        String avatar = response.extract().path("data[5].avatar");
        System.out.println("6. Avatar        :" + avatar);

        String supportUrl = response.extract().path("support.url");
        System.out.println("7. Support URL   :" + supportUrl);

        String supportText = response.extract().path("support.text");
        System.out.println("8. Support Text  :" + supportText);
        System.out.println("--------------- END of Printing Response ------------------");


    }

}