package com.api.reqres.Get_Tests;

import com.api.reqres.Utilities.GlobalData;
import com.api.reqres.Utilities.Resources;
import io.restassured.response.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetSingleUserNotFound {

    String parameter = "/users/23";
    String GET_SingleUsers_NotFound_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;

    @Test
    public void getSingleUserNotFound() {
        System.out.println("GET_SingleUsers_NotFound_EndPoint: " + GET_SingleUsers_NotFound_EndPoint);

        Response getSingleUserNotFound = given().
                when().
                get(GET_SingleUsers_NotFound_EndPoint);
        getSingleUserNotFound.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Clint_Error_Not_Found).log().all();
    }
}
