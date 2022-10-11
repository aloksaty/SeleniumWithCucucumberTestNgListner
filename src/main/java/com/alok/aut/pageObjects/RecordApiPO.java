package com.alok.aut.pageObjects;
import com.alok.aut.POJO.DataClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
/***
 *
 *
 *
 * User: alok
 * Date: 11/10/22
 *
 */
public class RecordApiPO {
    public static final String BASE_URL = "https://chercher.tech";

    public void readRecord () {
        RestAssured.baseURI = BASE_URL;
        Response resp = given ()
                .pathParam ("tail", "sample/api/product/read")
                .when ()
                .get ("/{tail}");
        System.out.println (resp.asString ());
        //DataClass dataClass[] = resp.jsonPath ().getObject ("records", DataClass[].class);
        //Assert.assertEquals (dataClass[0].getId (),"7387");
        //System.out.println ("############"+dataClass[0].getId ());

    }
}
