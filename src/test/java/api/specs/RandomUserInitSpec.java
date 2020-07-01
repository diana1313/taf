package api.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class RandomUserInitSpec {

    public static RestAssuredConfig getCustomTimeOut(RestAssuredConfig restAssuredConfig) {
        return restAssuredConfig.httpClient(HttpClientConfig.httpClientConfig()
                .setParam("http.connection.timeout",30_000)
                .setParam("http.socket.timeout",100_000));
    }

    public static RequestSpecification getRandomUser = new RequestSpecBuilder()
            .setConfig(getCustomTimeOut(RestAssuredConfig.config()))
            .setContentType(ContentType.JSON)
            .setBaseUri("https://randomuser.me/api/")
            .setBasePath("?inc=name")
            .build();
}
