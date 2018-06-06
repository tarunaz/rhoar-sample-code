package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.net.URL;

import org.arquillian.cube.kubernetes.annotations.Named;
import org.arquillian.cube.openshift.impl.enricher.AwaitRoute;
import org.arquillian.cube.openshift.impl.enricher.RouteURL;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.fabric8.kubernetes.api.model.v3_1.Service;
import io.fabric8.kubernetes.api.model.v3_1.ServiceList;
import io.fabric8.openshift.clnt.v3_1.OpenShiftClient;

@RunWith(Arquillian.class)
public class FruitControllerWSTest {

	@ArquillianResource
	private OpenShiftClient client;

	@ArquillianResource
	private ServiceList serviceList;

	@RouteURL("fruit")
	@AwaitRoute
	private URL route;

	@Named("fruit")
	@ArquillianResource
	Service fruit;

	// @Before
	// public void setUp() throws Exception {
	// this.base = new URL("http://localhost:" + port + "/");
	// }

	// @Test
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

	@Test
	public void testServicesInjection() {
		assertNotNull(serviceList);
		assertEquals(1, serviceList.getItems().size());
		assertEquals("fruit", serviceList.getItems().get(0).getMetadata().getName());

		assertNotNull(fruit);
		assertEquals("fruit", fruit.getMetadata().getName());

	}

}
