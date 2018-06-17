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

import io.fabric8.kubernetes.api.model.v3_1.Service;
import io.fabric8.kubernetes.api.model.v3_1.ServiceList;
import io.fabric8.openshift.clnt.v3_1.OpenShiftClient;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static io.restassured.RestAssured.given;

@Category(RequiresOpenshift.class)
@RequiresOpenshift
@RunWith(ArquillianConditionalRunner.class)
public class FruitControllerWSTest {

	@AwaitRoute
	@RouteURL("fruit")
	private URL baseURL;

	@Before
	public void setup() throws Exception {
		RestAssured.baseURI = baseURL.toString();
	}

	@Test
	public void shouldGetAllFruits_Test() {
		when().get().then().statusCode(200).body(containsString(
				"[{\"id\":1,\"name\":\"Cherry\"},{\"id\":2,\"name\":\"Apple\"},{\"id\":3,\"name\":\"Banana\"}]"));
	}

	@Test
	public void shouldGetFruitById_Test() {
		when().get("1").then().statusCode(200).body(containsString("[{\"id\":1,\"name\":\"Cherry\"}"));
	}

}
