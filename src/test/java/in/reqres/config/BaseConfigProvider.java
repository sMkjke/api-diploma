package in.reqres.config;

import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;

public class BaseConfigProvider {

    static BaseConfig config = ConfigFactory.create(BaseConfig.class);

    public static void configure() {
        RestAssured.baseURI = config.baseUrl();
    }

}
