package com.example;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;

//@Category(RequiresOpenshift.class)
//@RequiresOpenshift
//@RunWith(ArquillianConditionalRunner.class)
public class FruitControllerWSTest {

//	@AwaitRoute
//	@RouteURL("fruit")
//	private URL baseURL;

	//@Before
	//public void setup() throws Exception {
	//	RestAssured.baseURI = baseURL.toString();
	//}

	//@Test
	public void shouldGetAllFruits_Test() {
		when().get().then().statusCode(200).body(containsString(
				"[{\"id\":1,\"name\":\"Cherry\"},{\"id\":2,\"name\":\"Apple\"},{\"id\":3,\"name\":\"Banana\"}]"));
	}


}
