package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.dto.OperadorDto;
import br.inf.brunoruaro.dto.UsuarioDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class UsuarioControllerTest {

    @Test
    @DisplayName("Post a new User when the User is valid receive a 200 Ok")
    void postUser_whenUserIsValid_receiveOk() {
        given()
                .contentType("application/json")
                .body(createValidUser())
                .when()
                .post("/usuario/create")
                .peek()
                .then()
                .statusCode(200);
    }

    public UsuarioDto createValidUser() {
        return UsuarioDto.builder()
                .cpf(65739802474L)
                .email("teste@teste.com")
                .nome("Teste")
                .operadorId(createValidOperador())
                .build();
    }

    public OperadorDto createValidOperador() {
        return OperadorDto.builder()
                .nome("Teste")
                .build();
    }
}
