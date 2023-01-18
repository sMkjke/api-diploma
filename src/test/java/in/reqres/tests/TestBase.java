package in.reqres.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import in.reqres.config.BaseConfigProvider;

import static in.reqres.helpers.CustomApiListener.withCustomTemplates;

public class TestBase {

    @BeforeAll
    static void setUp() {
        RestAssured.filters(withCustomTemplates());
        BaseConfigProvider.configure();
    }

}
