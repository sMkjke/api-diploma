package in.reqres.specs;

import in.reqres.helpers.CustomApiListener;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RequestSpecs {

    public static final RequestSpecification REQUEST_SPECIFICATION = with()
            .filter(CustomApiListener.withCustomTemplates())
            .log().all()
            .contentType(JSON);

}
