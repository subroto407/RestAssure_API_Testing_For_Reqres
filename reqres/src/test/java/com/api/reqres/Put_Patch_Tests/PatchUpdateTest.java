package com.api.reqres.Put_Patch_Tests;

import com.api.reqres.Protocol_Design.PostUtils;
import com.api.reqres.Utilities.GlobalData;
import com.api.reqres.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PatchUpdateTest {

    String parameter = "/users/2";

    String PATCH_Update_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;

    @Test
    public void patchUpdateTest() {
        System.out.println("PATCHUpdate_EndPoint: " + PATCH_Update_EndPoint);


        Response patchUpdateTest = given().
                contentType("application/json")
                .body(PostUtils.json_Patch_Update)
                .when()
                .patch(PATCH_Update_EndPoint);
        patchUpdateTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.SuccessFull_Status_Code).log().all()
                .body("name", equalTo("mridul"))
                .body("job", equalTo("full stack sqa"));

    }
}
