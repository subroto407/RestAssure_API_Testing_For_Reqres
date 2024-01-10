package com.api.reqres.Post_Tests;

import com.api.reqres.Protocol_Design.PostUtils;
import com.api.reqres.Utilities.GlobalData;
import com.api.reqres.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PostLoginSuccessfulTest {

    String parameter = "/login";

    String POST_Login_Successful_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;

    @Test
    public void postLoginSuccessfulTest() {
        System.out.println("POSTLoginSuccessful_EndPoint: " + POST_Login_Successful_EndPoint);


        Response postLoginSuccessfulTest = given().
                contentType("application/json")
                .body(PostUtils.json_Post_Login_User)
                .when()
                .post(POST_Login_Successful_EndPoint);
        postLoginSuccessfulTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.SuccessFull_Status_Code).log().all()
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));



    }
}
