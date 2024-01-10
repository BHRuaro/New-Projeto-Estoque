package br.inf.brunoruaro.controller;

import java.util.HashMap;
import br.inf.brunoruaro.model.OperadorDAO;
import br.inf.brunoruaro.view.OperadorView;

public class OperadorController {
    static HashMap<String, String> parameters = new HashMap<>();

    public static boolean validateLogin() {

        parameters = OperadorView.requestLogin();

        if(OperadorDAO.login(parameters)){
            return true;
        }else{
            OperadorView.invalidLogin();
            return false;
        }
    }
}
