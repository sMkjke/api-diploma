package in.reqres.tests;

import in.reqres.models.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static in.reqres.helpers.ApiUtils.*;
import static in.reqres.specs.ResponseSpecs.NOT_FOUND_RESPONSE_SPECIFICATION;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTests extends TestBase {

    @Severity(NORMAL)
    @Feature("POST")
    @Tag("api")
    @Owner("Smkjke")
    @Test
    @DisplayName("Unsuccessfully login")
    void unsuccessfulLogin() {

        User randomUser = generateUser();
        User response = doPost(randomUser, "/login", NOT_FOUND_RESPONSE_SPECIFICATION)
                .extract()
                .as(User.class);

        assertEquals("user not found", response.getError());
    }

}
