package com.restassured.restapidefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.CoreMatchers;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Books {


    RequestSpecification baseRequest;
    RequestSpecification getRequest;
    RequestSpecification postRequest;
    RequestSpecification patchRequest;
    RequestSpecification deleteRequest;
    Response getResponse;
    Response postResponse;
    Response patchResponse;
    Response deleteResponse;

    @Before
    public void initiate() throws IOException {

        baseRequest = RestAssured.given()
                .baseUri("http://192.168.5.80:3000/api")
                .contentType(ContentType.JSON);

    }

    @Given("enter the post request url")
    public void enter_the_post_request_url() {
        // Write code here that turns the phrase above into concrete actions

        postRequest = baseRequest.request();

    }

    @Given("add book details")
    public void add_book_details() {
        // Write code here that turns the phrase above into concrete actions

        JSONObject object = new JSONObject();
        object.put("name","Harry Potter: The Chamber of Secrets");
        object.put("authorName","J.K.Roewling");
        object.put("publishedYear","1995");
        object.put("price",680);

        postRequest.body(object.toJSONString());

    }

    @When("post the Book details")
    public void post_the_book_details() {
        // Write code here that turns the phrase above into concrete actions

        postResponse = postRequest.when()
                .post("/v1/book/addBook");

        System.out.println("POST Request : "+postResponse.asPrettyString());
    }

    @Then("validate the status code")
    public void validate_the_status_code() {
        // Write code here that turns the phrase above into concrete actions

        postResponse.then().log().ifStatusCodeIsEqualTo(200);
    }

    @Then("validate the price")
    public void validate_the_price() {
        // Write code here that turns the phrase above into concrete actions

        postResponse.then().body("price",CoreMatchers.is(680)).log();
    }

    @Then("validate the author")
    public void validate_the_author() {
        // Write code here that turns the phrase above into concrete actions

        postResponse.then().body("authorName",CoreMatchers.is("J.K.Roewling"));
    }

    @Given("enter the get request url")
    public void enter_the_get_request_url() {
        // Write code here that turns the phrase above into concrete actions
        getRequest = baseRequest.request();
    }

    @When("get the book details")
    public void get_the_book_details() {
        // Write code here that turns the phrase above into concrete actions
        getResponse = getRequest.when().get("/v1/book/getAllBook");

        System.out.println("GET Response : "+getResponse.asPrettyString());
        getResponse.then().statusCode(200).log();

    }


    @Given("enter the patch request url")
    public void enter_the_patch_request_url() {
        // Write code here that turns the phrase above into concrete actions
        patchRequest = baseRequest.request();
    }

    @Given("update the data in book details")
    public void update_the_data_in_book_details() {
        // Write code here that turns the phrase above into concrete actions
        JSONObject patchDetails = new JSONObject();
        patchDetails.put("authorName", "George Miller");

        patchRequest.body(patchDetails.toJSONString());
    }

    @When("patch the book details")
    public void patch_the_book_details() {
        // Write code here that turns the phrase above into concrete actions
        patchResponse = patchRequest.when()
                .patch("/v1/book/updateBook/1");

        System.out.println("PATCH Response : "+patchResponse.asPrettyString());

        patchResponse.then().statusCode(200).log();
    }

    @Given("enter the delete request url")
    public void enter_the_delete_request_url() {
        // Write code here that turns the phrase above into concrete actions
        deleteRequest = baseRequest.request();

        deleteResponse = deleteRequest.when().delete("/v1/book/deleteBook/3");
        System.out.println("DELETE Response : "+deleteResponse.asPrettyString());

        deleteResponse.then().statusCode(200).log();
    }
}
