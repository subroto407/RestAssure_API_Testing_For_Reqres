package com.api.reqres.Delete_Test;

import com.api.reqres.Utilities.GlobalData;
import com.api.reqres.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class DeleteTest {

    String parameter = "/users/2";

    String Delete_End_Point = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;

    @Test
    public void deleteTest() {
        System.out.println("DeleteEndPoint: " + Delete_End_Point);


        Response deleteTest = given().
                when().
                delete(Delete_End_Point);
        deleteTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.No_Content).log().all();



    }
}
