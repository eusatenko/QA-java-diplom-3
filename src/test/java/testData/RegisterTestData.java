package testData;

import com.github.javafaker.Faker;

public class RegisterTestData {
    Faker faker = new Faker();
    public String name = faker.name().name();
    public String email = faker.internet().emailAddress();
    public String password = faker.internet().password(6,10);
}
