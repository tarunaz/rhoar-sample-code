package com.example;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.arquillian.cube.kubernetes.annotations.Named;
import org.arquillian.cube.openshift.impl.enricher.AwaitRoute;
import org.arquillian.cube.openshift.impl.enricher.RouteURL;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.jayway.restassured.RestAssured;

import static org.assertj.core.api.Assertions.assertThat;
import io.fabric8.kubernetes.api.model.v3_1.Service;

@RunWith(Arquillian.class)
public class FruitControllerWSTest {

	// private String port = "8080";

	@RouteURL("fruit")
	@AwaitRoute
	private URL base;

	@Named("fruit")
	@ArquillianResource
	Service fruit;

	// @Before
	// public void setUp() throws Exception {
	// this.base = new URL("http://localhost:" + port + "/");
	// }

	@Test
	public void shouuldGetAllFruits_Test() {

		assertThat(fruit).isNotNull();
		assertThat(fruit.getSpec()).isNotNull();
		assertThat(fruit.getSpec().getPorts()).isNotNull();
		assertThat(fruit.getSpec().getPorts()).isNotEmpty();

		// int expectedFruitCount = 0;
		//
		// final String actualFruitCount = RestAssured.get(base.toExternalForm()
		// + "rest/").asString();
		//
		// assertEquals(actualFruitCount, expectedFruitCount);
	}

}
