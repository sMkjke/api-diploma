package in.reqres.tests;

import in.reqres.models.UserList;
import in.reqres.models.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.helpers.ApiUtils.*;
import static in.reqres.specs.RequestSpecs.REQUEST_SPECIFICATION;
import static in.reqres.specs.ResponseSpecs.*;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersTests extends TestBase {

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
    void successUpdateUser() {
        var randomUser = generateUser();
        var response = doPut(randomUser, "/users/10", RESPONSE_SPECIFICATION)
                .extract()
                .as(User.class);

        assertEquals(randomUser.getName(), response.getName());
        assertEquals(randomUser.getJob(), response.getJob());
        assertEquals(randomUser.getPassword(), response.getPassword());
        assertEquals(randomUser.getFirstName(), response.getFirstName());
        assertEquals(randomUser.getLastName(), response.getLastName());

    }

    @Severity(BLOCKER)
    @Feature("POST")
    @Tag("api")
    @Owner("Smkjke")
    @Test
    @DisplayName("Successfully user registration")
    void SuccessUserRegistration() {
        var randomUser = generateUser();
        var response = doPost(randomUser, "/users", CREATE_USER_RESPONSE_SPECIFICATION)
                .extract()
                .as(User.class);

        assertEquals(randomUser.getName(), response.getName());
        assertEquals(randomUser.getJob(), response.getJob());
        assertEquals(randomUser.getPassword(), response.getPassword());
        assertEquals(randomUser.getFirstName(), response.getFirstName());
        assertEquals(randomUser.getLastName(), response.getLastName());

    }

    @Severity(NORMAL)
    @Feature("DELETE")
    @Tag("api")
    @Owner("Smkjke")
    @Test
    @DisplayName("Successfully delete user")
    void successDeleteUser() {
        given(REQUEST_SPECIFICATION)
                .when()
                .delete("users/5")
                .then()
                .spec(DELETE_USER_RESPONSE_SPECIFICATION);
    }

    @Severity(NORMAL)
    @Feature("GET")
    @Tag("api")
    @Owner("Smkjke")
    @Test
    @DisplayName("Check list size and expected user")
    void SizeOfUsersAndExpectedUserCheck() {

        var response = doGet("/users?page=1", RESPONSE_SPECIFICATION)
                .extract().as(UserList.class);

        assertEquals(6, response.getUserList().size());

        var expectedUser = response.getUserList().get(2);

        assertEquals("emma.wong@reqres.in", expectedUser.getEmail());
        assertEquals("Emma", expectedUser.getFirstName());
        assertEquals("Wong", expectedUser.getLastName());
        assertEquals("https://reqres.in/img/faces/3-image.jpg", expectedUser.getAvatar());
    }

}
