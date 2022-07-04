package pageMethods;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.fail;

public class PutMethods {

    public static String bodyPut = "{\n" +
            "  \"id\": 9223372036854024837,\n" +
            "  \"category\": {\n" +
            "    \"id\": 0,\n" +
            "    \"name\": \"put\"\n" +
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
    public static String bodyPutMethod;
    public static Long idPutMethod;
    public static Integer idCategoryPutMethod;
    public static String nameCategoryPutMethod;
    public static String namePutMethod;
    public static String statusPutMethod;

    public static void putMethod() {
        try {
            CommonsMethods.responsePutMethod =
                    given()
                            .header("Content-Type", "application/json")
                            .and()
                            .body(bodyPut)
                            .when()
                            .put(CommonsMethods.props.pathPut())
                            .then()
                            .extract()
                            .response();
        } catch (Exception e) {
            fail("An error occurred while executing the PUT method " + e);
        }
    }

    public static void checkResponsePutMethod() {
        bodyPutMethod = CommonsMethods.responsePutMethod.getBody().asString();
        idPutMethod = JsonPath.from(bodyPutMethod).get("id");
        idCategoryPutMethod = JsonPath.from(bodyPutMethod).get("category.id");
        nameCategoryPutMethod = JsonPath.from(bodyPutMethod).get("category.name");
        namePutMethod = JsonPath.from(bodyPutMethod).get("name");
        statusPutMethod = JsonPath.from(bodyPutMethod).get("status");

        Assert.assertNotEquals("The 'id' of modified object, should not match the previous", PostMethods.idPostMethod, idPutMethod);
        Assert.assertTrue("'id category' is not equals 0", idCategoryPutMethod == 0);
        Assert.assertEquals("'name category' is not equals 'string'", nameCategoryPutMethod, "put");
        Assert.assertEquals("'name' is not equals 'doggie'", namePutMethod, "doggie");
        Assert.assertEquals("'status' is not equals 'available'", statusPutMethod, "available");
    }

    public static void checkStatusCodePutMethod() {
        Assert.assertEquals("The status code does not match with the expected", 200, CommonsMethods.responsePutMethod.getStatusCode());
    }

}
