package com.alok.aut.pageObjects;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
/***
 *
 *
 *
 * User: alok
 * Date: 11/10/22
 *
 */
public class EmployeePO {

    public static final String BASE_URL = "http://dummy.restapiexample.com/api/v1/";
    public void readEmployeeRecords () {

        RestAssured.baseURI = BASE_URL;
        Response resp = given ()
                .pathParam ("tail", "employees")
                .when ()
                .get ("/{tail}");
        System.out.println ("********"+resp.asString ());
    }
}
