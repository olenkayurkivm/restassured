import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


/**
 * Created by OYurkiv on 4/11/2019.
 */
public class RestAssuredTest {
    final static Logger LOG = Logger.getLogger(RestAssuredTest.class);
    //private static WebDriver driver;


//    @BeforeMethod
//    public static void setUp(){
//        System.out.println("Hello finance!!");
//    }

    @Test
    public void test1() throws Exception{
//        RestAssured.baseURI = "http://api.rottentomatoes.com/api/public/v1.0";
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.get("/lists/movies/box_office.json");
//        LOG.info(String.format("Response : %s", response.getStatusCode()));
//
//        given()
//                .get("/lists/movies/box_office.json")
//                .then()
//                .statusCode(403);

        RestAssured.baseURI = "https://cat-fact.herokuapp.com";
//        RequestSpecification httpRequest = RestAssured.given().queryParam("animal_type", "cat").queryParam("amount", "2");
//        Response response = httpRequest.get("/facts/random");
//        LOG.info(String.format("Response : %s", response.getStatusCode()));
//        LOG.info(String.format("Response : %s", response.asString()));
//        LOG.info(String.format("Response : %s", response.getHeaders().asList().get(0)));
//        LOG.info(String.format("Response : %s", response.getContentType()));
        given()
                .queryParam("animal_type", "cat").queryParam("amount", "2")
                .get("/facts/random")
                .then()
                //.body("type", everyItem(equalTo("cat")));
                //.body("type", everyItem(startsWith("cat")));
                //.body("_id", hasSize(2));
                //.body("used", Matchers.hasSize(greaterThan(1)));
                //.body("used", hasItem(equalTo(false)));
                //.body("type", hasItem(allOf(startsWith("c"), endsWith("t"))));
                .body("type", hasItem(anyOf(startsWith("c"), equalTo("cat"))));


    }

    @Test
    public void test2() throws Exception{
        RestAssured.baseURI = "https://cat-fact.herokuapp.com";
        given()
                .queryParam("animal_type", "cat", "horse")
                .get("/facts")
                .then()
                .body("type", hasItem(anyOf(equalTo("cat"), equalTo("horse"))));
    }

    @Test
    public void test3() throws Exception{
        RestAssured.baseURI = "http://calapi.inadiutorium.cz/api/v0/en";
        given()
                .get("/calendars/default")
                .then()
                //.body("sanctorale.title", equalTo("General Roman Calendar"));
                //.body("system.effective_since", equalTo(1970));
                //.body("system.effective_since", equalTo(1970));
                //.body("system.desc", containsString("Paschalis"));
                //.body("system.desc", anything());
                .body("system.effective_since", lessThanOrEqualTo(1970));
    }

    @Test
    public void test4() throws Exception{
        RestAssured.baseURI = "http://calapi.inadiutorium.cz/api/v0/en";
        given()
                .get("/calendars")
                .then()
                //.body("[1].", equalTo("general-la"));
                //.body(".", hasItem(equalTo("general-la")));
                //.body(".", hasItems("general-en", "general-la" ));
                //.body(".", not(hasSize(17)));
                .body(".", hasItem(anyOf(equalTo("general-en"), containsString("czech"))));
    }

    @Test
    public void test5() throws Exception{
        RestAssured.baseURI = "http://calapi.inadiutorium.cz/api/v0/en";
        given()
                .get("/calendars/czech/today")
                .then()
                //.body("date", equalTo("2019-04-12")).and().body("weekday", equalTo("friday"));
                //.body("celebrations.title[0].", containsString("Monday of Holy Week"));
                .body("celebrations.title", hasItem(containsString("Monday of Holy Week")));

    }

    @Test
    public void test6() throws Exception{
        RestAssured.baseURI = "http://calapi.inadiutorium.cz/api/v0/fr";
        RestAssured.reset(); //reset to the standard REST-assured defaults
        RestAssured.baseURI = "http://calapi.inadiutorium.cz/api/v0/en";
        List<String> result = when().request("GET", "/calendars/default/2015/6/27")
        //given().get("/calendars/default/2015/6/27")
                .then()
                .statusCode(200)
                //.body("celebrations.colour", hasItem(equalTo("green"))).and().body("celebrations.colour", hasItem(equalTo("white")));
                //.body("celebrations.rank_num[0]", equalTo(3.13f));
                .body("celebrations.rank_num", hasItem(equalTo(3.12f)))
                .extract().path("celebrations.title");
        result.forEach(System.out::println);
    }

    @Test
    public void test7() throws Exception{
        RestAssured.baseURI = "http://calapi.inadiutorium.cz/api";
        given().log().all()
                .basePath("/v0/en")
                .pathParam("cal", "default")
                //.get("/calendars/default/2015/6/27")
                //.get("/calendars/{cal}/2015/6/27", "default")
                .get("/calendars/{cal}/2015/6/27")
                .then()
                .time(lessThan(10L), TimeUnit.SECONDS)
                .body("season", equalTo("ordinary"), "weekday", equalTo("saturday"));
    }

    @Test
    public void test8() throws Exception {
        //RestAssured.baseURI = "https://api.carbonintensity.org.uk";
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri("https://api.carbonintensity.org.uk")
                .setContentType(ContentType.ANY)
                .setAccept(ContentType.ANY);
        given().spec(requestBuilder.build())
                //.contentType(ContentType.ANY).accept(ContentType.ANY)
                .get("/regional")
                .then()
                .statusCode(200);

    }

    @Test
    public void test9() throws Exception{
        RestAssured.baseURI = "http://calapi.inadiutorium.cz/api";
        given().log().all()
                .basePath("/v0/en")
                .pathParam("cal", "default")
                .get("/calendars/{cal}/2015/6/27")
                .then()
                .time(lessThan(10L), TimeUnit.SECONDS);
                //.extract().body().as(SomePojo.class); this must be some object class
    }

    @Test
    public void test10() throws Exception{
        RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5";
        String coord = given()
                .get("/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
                .then()
                //.extract().path("coord").toString();
                .extract().response().path("coord").toString();
        LOG.info(coord);
    }
    //OpenWeatherMap api key: fd4698c940c6d1da602a70ac34f0b147

    @Test
    public void test11() throws Exception{
        RestAssured.baseURI = "http://petstore.swagger.io/v2";
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBody("{\n" +
                        "  \"id\": 123,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 123,\n" +
                        "    \"name\": \"test\"\n" +
                        "  },\n" +
                        "  \"name\": \"fluffy\",\n" +
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
                        "}");
        String id = given().spec(requestBuilder.build())
                //.contentType(ContentType.ANY).accept(ContentType.ANY)
                .get("/pet")
                .then()
                .statusCode(200)
                .extract().path("id").toString();
        LOG.info(id);
    }




//    @AfterMethod(alwaysRun = true)
//    public void tearDown() throws Exception {
//       DriverFactory.closeDriver();
//    }
}
