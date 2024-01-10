package br.inf.brunoruaro.view;

import br.inf.brunoruaro.controller.OperadorController;
import br.inf.brunoruaro.controller.MainController;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class MainView {

    public static void login() {
        boolean login = false;
        do {
            login = OperadorController.validateLogin();
        } while (!login);
    }

    public static void init() {
        int destino = 0;
        HashMap<String, String> parameters = new HashMap<>();

        destino = Integer.parseInt(JOptionPane.showInputDialog(
                "Escolha uma opção:\n1 - Usuários\n2 - Itens\n3 - Movimentações\n4 - Histórico\n5 - Sair do sistema\n(Informe uma opção)"));

        parameters.put("destino", String.valueOf(destino));

        MainController.goTo(parameters);
    }

    public static void invalidOption() {
        JOptionPane.showMessageDialog(null, "Opção inválida!");
        MainView.init();
    }

    public static void exit() {
        JOptionPane.showMessageDialog(null, "Saindo do sistema...");
        System.exit(0);
    }

}
