package in.reqres.helpers;

import in.reqres.models.User;

import static in.reqres.specs.RequestSpecs.REQUEST_SPECIFICATION;
import static in.reqres.specs.ResponseSpecs.CREATE_USER_RESPONSE_SPECIFICATION;
import static in.reqres.specs.ResponseSpecs.RESPONSE_SPECIFICATION;
import static io.restassured.RestAssured.given;

public class ApiUtils {

    private static final GenerateData generateData = new GenerateData();

    public static User generateUser() {
        return User
                .builder()
                .name(generateData.getName())
                .job(generateData.getJob())
                .password(generateData.getPassword())
                .firstName(generateData.getFirstName())
                .lastName(generateData.getLastName())
                .build();
    }

    public static User createUser(final User user) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(user)
                .when()
                .post("/users")
                .then()
                .spec(CREATE_USER_RESPONSE_SPECIFICATION)
                .extract().as(User.class);
    }

    public static User updateUser(final User user) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(user)
                .when()
                .put("/users/10")
                .then()
                .spec(RESPONSE_SPECIFICATION)
                .log().body()
                .extract().as(User.class);
    }

}
