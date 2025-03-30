package com.example.sokolova_alena;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SokolovaAlenaApplicationTests {

    RequestSpecification request;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @BeforeEach
    public void setRequest() {
        request = RestAssured.given();
    }


    @Test
    void contextLoads() {
    }

    @Test
    void shouldGetStringWithoutParams() {
        Response response = request.get("/getString");

        assertThat(response)
                .extracting(Response::getContentType,
                        Response::getStatusCode)
                .containsExactly(
                        "text/plain;charset=UTF-8",
                        200
                );

        assertThat(response.body().print()).isEqualTo("empty");

//		Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    void shouldGetStringWithParams() {
        String param = "  приветик ромашки иии.   fff.  ";
        Response response = request
                .param("str", param)
                .get("/getString");

        assertThat(response)
                .extracting(Response::getContentType,
                        Response::getStatusCode)
                .containsExactly(
                        "text/plain;charset=UTF-8",
                        200);
        assertThat(response.body().print()).isEqualTo(param);

    }

    @Test
    void shouldGetObject (){
        Response response = request.get("/getObject");

        assertThat(response)
                .extracting(Response::getContentType,
                        Response::getStatusCode)
                .containsExactly(
                        "text/plain;charset=UTF-8",
                        200);

    }

    @Test
    void checkParams() {
        RequestSpecification request = RestAssured.given();
        RestAssured.baseURI = "http://localhost:8080";
        Response response = request.get("/getString");
        Assertions.assertEquals(200, response.getStatusCode());

    }

}
