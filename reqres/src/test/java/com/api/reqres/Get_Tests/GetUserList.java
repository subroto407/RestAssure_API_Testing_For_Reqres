package com.api.reqres.Get_Tests;

import com.api.reqres.Utilities.GlobalData;
import com.api.reqres.Utilities.Resources;

import org.testng.annotations.Test;
import io.restassured.response.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetUserList {

    String parameter = "/users?";
    String page = "page=";
    int two = 2;

    String GET_Users_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter + page + two;

    @Test
    public void getUserList() {
        System.out.println("GETUsersEndPoint: " + GET_Users_EndPoint);

        Response getuserList = given().
                when().
                get(GET_Users_EndPoint);
        getuserList.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.SuccessFull_Status_Code).log().all()
                .body("page", equalTo(2),
                        "per_page", equalTo(6),
                        "total", equalTo (12),
                        "total_pages", equalTo (2));





    }

}
