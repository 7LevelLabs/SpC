package ua.ll7.slot21.spc.rs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.ll7.slot21.spc.util.request.Method2Request;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsIn.isOneOf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
public class SpCControllerIT {

	@Test
	public void testMethod1() throws Exception {
		String stringToGet = "http://localhost:8080/rs/spc/method1/1";

		given()
			.log().everything()
			.contentType("application/xml; charset=UTF-8")
		.when()
			.get(stringToGet)
		.then()
			.statusCode(isOneOf(200, 201))
			.body("response.data", equalTo("5"))
		;
	}

	@Test
	public void testMethod2() throws Exception {
		Method2Request request = new Method2Request(1,2,3);

		String stringToPost = "http://localhost:8080/rs/spc/method2";

		given()
			.log().everything()
			.contentType("application/xml; charset=UTF-8")
			.body(request)
		.when()
			.post(stringToPost)
		.then()
			.statusCode(isOneOf(200, 201))
			.body("response.data", equalTo("0"))
		;

	}
}