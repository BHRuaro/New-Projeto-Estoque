package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Usuario;
import br.inf.brunoruaro.resources.UsuarioResource;
import com.google.gson.JsonObject;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class UsuarioResourceTest {

    @Inject
    UsuarioController usuarioController;

    @Inject
    UsuarioResource usuarioResource;

    @BeforeEach
    public void setup() throws ApiException {
        Usuario usuario;
        usuario = usuarioController.findByCpf(68729265541L);
        if(usuario != null){
            usuarioResource.delete(usuario.getUsuarioId());
        }
    }

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

    @Test
    @DisplayName("Post a new User when User CPF is invalid receive a 400 Bad request")
    void postUser_whenUserIsInvalid_receiveBadRequest() {
        JsonObject user = createValidUser();
        user.addProperty("cpf", 99999999999L);
        given().
                contentType("application/json").
                body(user.toString()).
                when().
                post("/usuario/create").
                then().
                statusCode(400)
                .body("message", equalTo("CPF do usuário inválido"));
    }

    @Test
    @DisplayName("Post a new User when User Name is empty receive a 400 Bad request")
    void postUser_whenUserNameIsEmpty_receiveBadRequest() {
        JsonObject user = createValidUser();
        user.addProperty("nome", "");
        given().
                contentType("application/json").
                body(user.toString()).
                when().
                post("/usuario/create").
                then().
                statusCode(400)
                .body("message", equalTo("Nome do usuário não pode ser vazio"));
    }

    @Test
    @DisplayName("Post a new User when User Email is invalid receive a 400 Bad request")
    void postUser_whenUserEmailIsInvalid_receiveBadRequest() {
        JsonObject user = createValidUser();
        user.addProperty("email", "teste.com");
        given().
                contentType("application/json").
                body(user.toString()).
                when().
                post("/usuario/create").
                then().
                statusCode(400)
                .body("message", equalTo("Email do usuário inválido"));
    }

    public JsonObject createValidUser() {

        JsonObject user = new JsonObject();
        user.addProperty("cpf", 68729265541L);
        user.addProperty("email", "teste@teste.com");
        user.addProperty("nome", "Teste");
        user.addProperty("operadorId", 1);

        return user;
    }

}
