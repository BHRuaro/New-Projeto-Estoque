package br.inf.brunoruaro.controller;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class OperadorControllerTest {

    @Inject
    OperadorController controller;

    @Test
    void testLogin() {
        boolean valid = controller.validateLogin();
        assertTrue(valid);
    }

}