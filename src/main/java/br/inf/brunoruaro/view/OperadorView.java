package br.inf.brunoruaro.view;

import java.util.HashMap;
import javax.swing.JOptionPane;

public class OperadorView {
    static HashMap<String, String> parameters = new HashMap<>();

    public static HashMap<String, String> requestLogin() {
        String user, password;

        user = JOptionPane.showInputDialog("Digite o nome do operador:");
        password = JOptionPane.showInputDialog("Digite a senha do operador:");
        parameters.put("user", user);
        parameters.put("password", password);

        return parameters;
    }

    public static void invalidLogin(){
        JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
    }
}
