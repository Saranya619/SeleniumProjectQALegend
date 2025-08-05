package utilities;

import java.util.Locale;
import com.github.javafaker.Faker;

public class RandomDataGeneration {

	public static String getName() {
		Faker faker = new Faker();
		return faker.name().name();
	}

	public static String getFirstName() {
		Faker faker = new Faker(new Locale("en-US"));
		return faker.name().firstName();
	}

	public static String getLastName() {
		Faker faker = new Faker(new Locale("en-IND"));
		return faker.name().lastName();
	}

	public static String getCity() {
		Faker faker = new Faker();
		return faker.address().city();
	}

	public static String getEmail() {
		Faker faker = new Faker();
		return faker.internet().emailAddress();
	}
	
	public static String getPhoneNumber() {
		Faker faker = new Faker();
		return faker.phoneNumber().phoneNumber();
	}

	public static String generateEmail() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName().toLowerCase();
		String lastName = faker.name().lastName().toLowerCase();
		int randomNum = faker.number().numberBetween(100, 999);
		String domain = faker.internet().domainName(); // e.g., "example.com"

		return firstName + "." + lastName + randomNum + "@" + domain;
	}

	public static String getPasword() {
		Faker faker = new Faker();
		return faker.internet().password();
	}

	public static String getZipCode() {
		Faker faker = new Faker();
		return faker.address().zipCode();
	}
	
	public static String getUsername() {
		Faker faker = new Faker();
		 return faker.name().username().replace(".", "");
	}
}
