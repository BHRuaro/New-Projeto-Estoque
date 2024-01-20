package br.inf.brunoruaro.controller;

import java.util.HashMap;
import br.inf.brunoruaro.model.OperadorDAO;
import br.inf.brunoruaro.view.OperadorView;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;

@RequestScoped
public class OperadorController {

    @Inject
    OperadorDAO operadorDAO;

    static HashMap<String, String> parameters = new HashMap<>();

    public boolean validateLogin() {

        parameters = OperadorView.requestLogin();
        if(operadorDAO.login(parameters)){
            return true;
        }else{
            OperadorView.invalidLogin();
            return false;
        }
    }
}
