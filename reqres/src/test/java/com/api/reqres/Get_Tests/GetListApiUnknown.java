package com.api.reqres.Get_Tests;

import com.api.reqres.Utilities.GlobalData;
import com.api.reqres.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GetListApiUnknown {

    String parameter = "/unknown";
    String page ="page=";
    int one = 1;

    String GET_List_ApiUnknown_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter + page + one;


    @Test
    public void getListApiUnknown() {
        System.out.println("GETListApiUnknown_EndPoint: " + GET_List_ApiUnknown_EndPoint);


        Response getApiUnknown = given().
                when().
                get(GET_List_ApiUnknown_EndPoint);
        getApiUnknown.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.SuccessFull_Status_Code).log().all()
                .body("page", equalTo(1),
                        "per_page", equalTo(6),
                        "total", equalTo (12),
                        "total_pages", equalTo (2));
    }
}
