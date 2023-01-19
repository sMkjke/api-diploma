package in.reqres.helpers;

import in.reqres.models.User;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

import static in.reqres.specs.RequestSpecs.REQUEST_SPECIFICATION;
import static io.restassured.RestAssured.given;

public class ApiUtils {

    private static final GenerateData generateData = new GenerateData();

    public static <T> ValidatableResponse doPost(final T body,
                                                 final String url,
                                                 final ResponseSpecification spec) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(body)
                .when()
                .post(url)
                .then().spec(spec);

    }

    public static <T> ValidatableResponse doPut(final T body,
                                                final String url,
                                                final ResponseSpecification spec) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(body)
                .when()
                .put(url)
                .then()
                .spec(spec);
    }

    public static <T> ValidatableResponse doGet(final String url, final ResponseSpecification spec) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .when()
                .get(url)
                .then()
                .spec(spec);
    }


    public static User generateUser() {
        return User
                .builder()
                .email(generateData.getEmail())
                .password(generateData.getPassword())
                .name(generateData.getName())
                .job(generateData.getJob())
                .password(generateData.getPassword())
                .firstName(generateData.getFirstName())
                .lastName(generateData.getLastName())
                .build();
    }


}
