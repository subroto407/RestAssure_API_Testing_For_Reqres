package com.api.reqres.Post_Tests;

import com.api.reqres.Protocol_Design.PostUtils;
import com.api.reqres.Utilities.GlobalData;
import com.api.reqres.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PostRegisterUserTest {
    String parameter = "/register";

    String POST_RegisterUsers_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;

    @Test
    public void postRegisterUserTest() {
        System.out.println("POSTRegisterUsers_EndPoint: " + POST_RegisterUsers_EndPoint);


        //final String json ="{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}";
        Response postRegisterUserTest = given().
                contentType("application/json")
                //.body(PostUtils.json_Post_Register_UserName + PostUtils.json_Post_Register_Password)
                .body(PostUtils.json_Post_Register_User)
                .when()
                .post(POST_RegisterUsers_EndPoint);
        postRegisterUserTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.SuccessFull_Status_Code).log().all()
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));


    }


}
