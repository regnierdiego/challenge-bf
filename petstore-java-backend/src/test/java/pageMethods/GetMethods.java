package pageMethods;

import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.fail;

public class GetMethods {

    public static String bodyGetMethod;
    public static Long idGetMethod;
    public static Integer idCategoryGetMethod;
    public static String nameCategoryGetMethod;
    public static String nameGetMethod;
    public static String statusGetMethod;

    public static void getMethod() {
        try {
            CommonsMethods.responseGetMethod =
                    given()
                            .header("Content-Type", "application/json")
                            .when()
                            .get(CommonsMethods.props.pathGet() + PostMethods.idPostMethod)
                            .then()
                            .extract()
                            .response();
        } catch (Exception e) {
            fail("An error occurred while executing the GET method " + e);
        }
    }

    public static void checkResponseGetMethod() {
        bodyGetMethod = CommonsMethods.responseGetMethod.getBody().asString();
        idGetMethod = JsonPath.from(bodyGetMethod).get("id");
        idCategoryGetMethod = JsonPath.from(bodyGetMethod).get("category.id");
        nameCategoryGetMethod = JsonPath.from(bodyGetMethod).get("category.name");
        nameGetMethod = JsonPath.from(bodyGetMethod).get("name");
        statusGetMethod = JsonPath.from(bodyGetMethod).get("status");

        Assert.assertEquals(PostMethods.idPostMethod, idGetMethod);
        Assert.assertTrue("'id category' is not equals 0", idCategoryGetMethod == 0);
        Assert.assertEquals("'name category' is not equals 'string'", nameCategoryGetMethod, "string");
        Assert.assertEquals("'name' is not equals 'doggie'", nameGetMethod, "doggie");
        Assert.assertEquals("'status' is not equals 'available'", statusGetMethod, "available");
    }

    public static void checkStatusCodeGetMethod() {
        Assert.assertEquals("The status code does not match with the expected", 200, CommonsMethods.responseGetMethod.getStatusCode());
    }

}
