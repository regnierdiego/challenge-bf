package pageMethods;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.fail;

public class PostMethods {

    public static String bodyPost = "{\n" +
            "  \"id\": 0,\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"string\"\n" +
            "  },\n" +
            "  \"name\": \"doggie\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 0,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";
    public static String bodyPetPostMethod;
    public static Long idPostMethod;
    public static Integer idCategoryPostMethod;
    public static String nameCategoryPostMethod;
    public static String namePostMethod;
    public static String statusPostMethod;

    public static void postMethod() {
        try {
            CommonsMethods.responsePostMethod =
                    given()
                            .header("Content-Type", "application/json")
                            .and()
                            .body(bodyPost)
                            .when()
                            .post(CommonsMethods.props.pathPost())
                            .then()
                            .extract()
                            .response();
        } catch (Exception e) {
            fail("An error occurred while executing the POST method " + e);
        }
    }

    public static void checkResponsePostMethod() {
        bodyPetPostMethod = CommonsMethods.responsePostMethod.getBody().asString();
        idPostMethod = JsonPath.from(bodyPetPostMethod).get("id");
        idCategoryPostMethod = JsonPath.from(bodyPetPostMethod).get("category.id");
        nameCategoryPostMethod = JsonPath.from(bodyPetPostMethod).get("category.name");
        namePostMethod = JsonPath.from(bodyPetPostMethod).get("name");
        statusPostMethod = JsonPath.from(bodyPetPostMethod).get("status");

        Assert.assertNotNull("'id' is null ", idPostMethod);
        Assert.assertTrue("'id category' is not equals 0", idCategoryPostMethod == 0);
        Assert.assertEquals("'name category' is not equals 'string'", nameCategoryPostMethod, "string");
        Assert.assertEquals("'name' is not equals 'doggie'", namePostMethod, "doggie");
        Assert.assertEquals("'status' is not equals 'available'", statusPostMethod, "available");

    }

    public static void checkStatusCodePostMethod() {
        Assert.assertEquals("The status code does not match with the expected", 200, CommonsMethods.responsePostMethod.getStatusCode());
    }

}
