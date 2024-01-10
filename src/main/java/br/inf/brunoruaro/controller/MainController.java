package br.inf.brunoruaro.controller;

import java.util.HashMap;
import br.inf.brunoruaro.view.MainView;

public class MainController {

    public static void login() {
        MainView.login();
        init();
    }

    public static void init() {
        MainView.init();
    }

    public static void goTo(HashMap<String, String> parametros) {
        int destino = Integer.parseInt(parametros.get("destino"));

        switch (destino) {
//            case 1 -> UsuarioController.init();
//            case 2 -> ItemController.init();
//            case 3 -> MovimentacaoController.init();
//            case 4 -> HistoricoController.init();
//            case 5 -> MainView.exit();
//            default -> MainView.invalidOption();
        }
    }
}