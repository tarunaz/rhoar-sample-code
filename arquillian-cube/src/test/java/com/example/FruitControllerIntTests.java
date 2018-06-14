package com.example;

//import io.fabric8.kubernetes.api.model.v3_1.Service;
//import org.arquillian.cube.kubernetes.annotations.Named;
//import org.arquillian.cube.openshift.impl.enricher.AwaitRoute;
//import org.arquillian.cube.openshift.impl.enricher.RouteURL;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.builder.RequestSpecBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

//@RunWith(Arquillian.class)
public class FruitControllerIntTests {

   // @RouteURL("fruits")
    //@AwaitRoute
    private URL route;

   // @Named("fruits")
    //@ArquillianResource
    //Service fruits;

    //@Test
    public void test_VerifyFruitsServiceIsNotNull() throws IOException {
      //  assertThat(fruits).isNotNull();
        //assertThat(fruits.getSpec()).isNotNull();
        //assertThat(fruits.getSpec().getPorts()).isNotNull();
        //assertThat(fruits.getSpec().getPorts()).isNotEmpty();
    }

   // @Test
    public void test_FruitsGetAllIsAvailable() {
        RequestSpecBuilder requestSpecBuilder = getRequestSpecBuilder();

        given(requestSpecBuilder.build())
                .when().get()
                .then()
                .statusCode(200)
                .body(containsString("Arni"));
    }

    //@Test
    public void test_FruitsGetByIdIsAvailable() {
        RequestSpecBuilder requestSpecBuilder = getRequestSpecBuilder();

        given(requestSpecBuilder.build())
                .param("id", "1000")
                .when().get()
                .then()
                .statusCode(200)
                .body(containsString("Duke Nukem"));
    }

    private RequestSpecBuilder getRequestSpecBuilder() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(String.format("http://%s/api/fruits/", Objects.requireNonNull(route).getHost()));
        return requestSpecBuilder;
    }
}
