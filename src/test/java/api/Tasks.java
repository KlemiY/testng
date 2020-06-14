package test.java.api;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class Tasks {
    long newTaskId;

    @Test
    public void getTaskMethod() {

        String firstContentName = "Click this task to see more details";

        Response response = given().
                header("Authorization", "Bearer 43901e9fcfdef6017d7958fd76598ee0da76bfc2").
                when().
                get("https://api.todoist.com/rest/v1/tasks");
        JsonPath path = response.jsonPath();
        List<Map> list = path.getList("");
        List<String> actualNames = new ArrayList<>();
        for (Map project: list) {
            actualNames.add((String) project.get("content"));
        }
        response.
                then().
                statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("getTaskBodyValidation.json"));;
        assertEquals(actualNames.get(0), "Click this task to see more details");
        actualNames.remove(0);
        for (String name: actualNames) assertFalse(name.equals("Click this task to see more details"),
                String.format("Expected content '%s' not to be 'Click this task to see more details',", name));
    }

    @Test
    public void createTask() {
        newTaskId =
        given().
                header("Authorization", "Bearer 43901e9fcfdef6017d7958fd76598ee0da76bfc2").
                contentType(ContentType.JSON).
                body(new File("createTaskBody.json")).
        when().
                post("https://api.todoist.com/rest/v1/tasks").
        then().
                statusCode(200).
                extract().
                path("id");
    }

    @Test(dependsOnMethods = "createTask")
    public void deleteTask() {
         given().
                 header("Authorization", "Bearer 43901e9fcfdef6017d7958fd76598ee0da76bfc2").

         when().
                 delete("https://api.todoist.com/rest/v1/tasks/" + newTaskId).
         then().
                 statusCode(204);

    }

    @Test
    public void updateTask() {
        given().
                header("Authorization", "Bearer 43901e9fcfdef6017d7958fd76598ee0da76bfc2").
                contentType(ContentType.JSON).
                body(new File("updateTaskBody.json")).
        when().
                post("https://api.todoist.com/rest/v1/tasks/3969129831").
        then().
                statusCode(204);
    }
}
