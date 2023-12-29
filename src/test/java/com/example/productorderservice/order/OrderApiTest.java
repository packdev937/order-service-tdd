package com.example.productorderservice.order;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class OrderApiTest extends ApiTest {

    @Test
    void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());

        ExtractableResponse<Response> response = RestAssured
            .given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(상품주문요청_생성())
            .when()
            .post("/orders")
            .then().log().all()
            .extract();

        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static CreateOrderRequest 상품주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 2;
        CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
        return request;
    }
}
