package in.reqres.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.BODY;

public class ResponseSpecs {

    public static final ResponseSpecification RESPONSE_SPECIFICATION = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static final ResponseSpecification CREATE_USER_RESPONSE_SPECIFICATION = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(201)
            .build();

    public static ResponseSpecification DELETE_USER_RESPONSE_SPECIFICATION = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(204)
            .build();

    public static ResponseSpecification NOT_FOUND_RESPONSE_SPECIFICATION = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(400)
            .build();

}
