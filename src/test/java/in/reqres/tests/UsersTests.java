package in.reqres.tests;

import in.reqres.models.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.helpers.ApiUtils.*;
import static in.reqres.specs.RequestSpecs.REQUEST_SPECIFICATION;
import static in.reqres.specs.ResponseSpecs.RESPONSE_SPECIFICATION;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTests extends TestBase {

    @Severity(NORMAL)
    @Feature("GET")
    @Tag("api")
    @Owner("Smkjke")
    @DisplayName("Find persons with date >= 12")
    @Test
    void checkPersonsDateWithLongName() {
        given(REQUEST_SPECIFICATION)
                .when()
                .get("/unknown")
                .then()
                .spec(RESPONSE_SPECIFICATION)
                .body("data.findAll{ it.name.length() >= 12 }.year",
                        hasItems(2001, 2005));
    }

    @Severity(NORMAL)
    @Feature("UPDATE")
    @Tag("api")
    @Owner("Smkjke")
    @Test
    @DisplayName("Update User")
    void UpdateUser() {
        User randomUser = generateUser();
        User response = updateUser(randomUser);

        assertEquals(randomUser.getName(), response.getName());
        assertEquals(randomUser.getJob(), response.getJob());
        assertEquals(randomUser.getPassword(), response.getPassword());
        assertEquals(randomUser.getFirstName(), response.getFirstName());
        assertEquals(randomUser.getLastName(), response.getLastName());

    }

    @Severity(NORMAL)
    @Feature("POST")
    @Tag("api")
    @Owner("Smkjke")
    @Test
    @DisplayName("Successfully user registration")
    void SuccessUserRegistration() {
        User randomUser = generateUser();
        User response = createUser(randomUser);

        assertEquals(randomUser.getName(), response.getName());
        assertEquals(randomUser.getJob(), response.getJob());
        assertEquals(randomUser.getPassword(), response.getPassword());
        assertEquals(randomUser.getFirstName(), response.getFirstName());
        assertEquals(randomUser.getLastName(), response.getLastName());

    }

}
