package br.inf.brunoruaro.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import br.inf.brunoruaro.model.UsuarioDAO;
import br.inf.brunoruaro.model.Usuario;

@RequestScoped
public class UsuarioController {

    @Inject
    UsuarioDAO usuarioDAO;

    @Inject
    HistoricoCadastrosController historicoCadastrosController;

    public Integer usuarioCreate(Usuario usuario){
        usuarioDAO.add(usuario);

        historicoCadastrosController.adicionaCadastro(usuario);

        return usuario.getUsuarioId();
    }

    public Usuario usuarioFind(Integer usuarioId){
        return usuarioDAO.find(usuarioId);
    }

    public void usuarioRemove(Integer usuarioId){
        Usuario usuario = usuarioDAO.find(usuarioId);
        usuarioDAO.remove(usuario);
    }

    public Usuario usuarioUpdate(Usuario usuario){
        return usuarioDAO.update(usuario);
    }

    public Object usuarioList(){
        return usuarioDAO.list();
    }
}
