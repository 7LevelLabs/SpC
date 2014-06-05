package ua.ll7.slot21.spc.rs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsIn.isOneOf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfigIT.xml")
public class FDataControllerIT {

	@Test
	public void testGetFDataAsString() throws Exception {
		String stringToGet = "http://localhost:8080/rs/spc/getFDataAsString/1";

		given()
			.log().everything()
			.contentType("application/xml; charset=UTF-8")
			.when()
			.get(stringToGet)
			.then()
			.statusCode(isOneOf(200, 201))
			.body("fResponse.data", equalTo("0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20"))
		;
	}
}