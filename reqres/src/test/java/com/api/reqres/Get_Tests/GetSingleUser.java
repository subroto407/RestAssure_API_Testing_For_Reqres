package com.api.reqres.Get_Tests;

import com.api.reqres.Utilities.GlobalData;
import com.api.reqres.Utilities.Resources;
import io.restassured.response.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetSingleUser {

    String parameter = "/users/2";

    String GET_Single_Users_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;


    @Test
    public void getSingleUser() {
        System.out.println("GETSingleUsersEndPoint: " + GET_Single_Users_EndPoint);

        Response getSingleuser = given().
                when().
                get(GET_Single_Users_EndPoint);
        getSingleuser.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.SuccessFull_Status_Code).log().all()
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));




    }

}
