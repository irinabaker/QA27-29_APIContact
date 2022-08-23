package com.telran.contacts.tests;

import com.jayway.restassured.RestAssured;
import com.telran.contacts.dto.ContactDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class DeleteContactByIdRestAssuredTests {

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Implc3NlKzk4MUBtYWlsLnJ1In0.iRv_cToiozRNs_yAsjF132RI5xIkK-FPDciXEKvS7fs";

    int id;

    @BeforeMethod
    public void ensurePrecondition() {
        RestAssured.baseURI = "https://contacts-telran.herokuapp.com";
        RestAssured.basePath = "api";

        int i = (int) ((System.currentTimeMillis()/1000)%3600);

        ContactDto contactDto = ContactDto.builder()
                .address("Dortmund")
                .description("Forward")
                .email("emre" + i + "@gmail.com")
                .lastName("Can")
                .name("Emre")
                .phone("23982384" + i)
                .build();

        id = given().header("Authorization", token)
                .contentType("application/json")
                .body(contactDto)
                .post("contact")
                .then()
                .assertThat().statusCode(200)
                .extract().path("id");
    }

    @Test
    public void deleteByIdTest() {
        String status = given().header("Authorization", token)
                .delete("contact/" + id)
                .then()
                .assertThat().statusCode(200)
                .extract().path("status");
        System.out.println(status);
    }
}
