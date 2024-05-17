package br.inf.brunoruaro.controller;

import com.google.gson.JsonObject;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@QuarkusTest
public class UsuarioControllerTest {

    @Test
    @DisplayName("Post a new User when the User is valid receive a 200 Ok")
    void postUser_whenUserIsValid_receiveOk() {

        given().
                contentType("application/json").
                body(createValidUser().toString()).
                when().
                post("/usuario/create").
                then().
                statusCode(200);
    }

    public JsonObject createValidUser() {

        JsonObject operador = new JsonObject();
        operador.addProperty("operadorId", 1);
        operador.addProperty("nome", "Teste");
        operador.addProperty("senha", "123456");


        JsonObject user = new JsonObject();
        user.addProperty("cpf", 68729265541L);
        user.addProperty("email", "teste@teste.com");
        user.addProperty("nome", "Teste");
        user.add("operador", operador);

        return user;
    }
}
