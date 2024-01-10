package com.api.reqres.Get_Tests;


import com.api.reqres.Utilities.GlobalData;
import com.api.reqres.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class GetApiSingleOnlyUnknownNotFound {

    String parameter = "/unknown/23";
    String GET_Single_OnlyUnknown_NotFound_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;

    @Test
    public void getApiSingleOnlyUnknownNotFound() {
        System.out.println("GETSingleOnlyUnknownNotFoundEndPoint: " + GET_Single_OnlyUnknown_NotFound_EndPoint);


        Response getApiSingleOnlyUnknownNotFound = given().
                when().
                get(GET_Single_OnlyUnknown_NotFound_EndPoint);
        getApiSingleOnlyUnknownNotFound.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Clint_Error_Not_Found).log().all();
    }
}
