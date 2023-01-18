package in.reqres.helpers;

import com.github.javafaker.Faker;
import lombok.Data;

@Data
public class GenerateData {

    Faker faker = new Faker();

    private String
            name = faker.name().fullName(),
            email = faker.internet().emailAddress(),
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            password = faker.internet().password(),
            job = faker.job().title();

}
