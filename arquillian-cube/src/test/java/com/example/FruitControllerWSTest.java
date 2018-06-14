package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.net.URL;

import org.arquillian.cube.kubernetes.annotations.Named;
import org.arquillian.cube.openshift.impl.enricher.AwaitRoute;
import org.arquillian.cube.openshift.impl.enricher.RouteURL;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import com.jayway.restassured.RestAssured;

import io.fabric8.kubernetes.api.model.v3_1.Service;
import io.fabric8.kubernetes.api.model.v3_1.ServiceList;
import io.fabric8.openshift.clnt.v3_1.OpenShiftClient;


import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static io.restassured.RestAssured.given;

@Category(RequiresOpenshift.class)
@RequiresOpenshift
@RunWith(ArquillianConditionalRunner.class)
public class FruitControllerWSTest {

//	@ArquillianResource
//	private OpenShiftClient client;

//	@ArquillianResource
//	private ServiceList serviceList;

	@AwaitRoute
	@RouteURL("${app.name}")
	private URL baseURL;

	@Before
	public void setup() throws Exception {
		RestAssured.baseURI = baseURL.toString();
	}

	// @Named("fruit")
	// @ArquillianResource
	// Service fruit;

	// @Before
	// public void setUp() throws Exception {
	// this.base = new URL("http://localhost:" + port + "/");
	// }

	@Test
	public void testGreetingEndpoint() {
		when().get().then().statusCode(200).body(containsString("Greetings from Spring Boot!"));
	}

	// @Test
	// public void shouuldGetAllFruits_Test() {
	//
	// assertThat(fruit).isNotNull();
	// assertThat(fruit.getSpec()).isNotNull();
	// assertThat(fruit.getSpec().getPorts()).isNotNull();
	// assertThat(fruit.getSpec().getPorts()).isNotEmpty();

	// int expectedFruitCount = 0;
	//
	// final String actualFruitCount = RestAssured.get(base.toExternalForm()
	// + "rest/").asString();
	//
	// assertEquals(actualFruitCount, expectedFruitCount);
	// }

	// @Test
	// public void testServicesInjection() {
	// assertNotNull(serviceList);
	// assertEquals(1, serviceList.getItems().size());
	// assertEquals("fruit",
	// serviceList.getItems().get(0).getMetadata().getName());
	//
	// assertNotNull(fruit);
	// assertEquals("fruit", fruit.getMetadata().getName());
	//
	// }

}
