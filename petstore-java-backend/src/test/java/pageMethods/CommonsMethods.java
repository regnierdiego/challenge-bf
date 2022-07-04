package pageMethods;

import configuration.Iproperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;

import java.util.Random;

public class CommonsMethods {

    public static Iproperties props = ConfigFactory.create(Iproperties.class);

    public static Random random = new Random();
    public static int randomValue = 1 + random.nextInt(999999999);
    public static int fullNameNumber = randomValue;
    public static Response responsePostMethod;
    public static Response responseGetMethod;
    public static Response responsePutMethod;


    @Before
    public static void setup() {
        RestAssured.baseURI = props.url();
    }

    @After
    public static void tearDown() {

    }
}
