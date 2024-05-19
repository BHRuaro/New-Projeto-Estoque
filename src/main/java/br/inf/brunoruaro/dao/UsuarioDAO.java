package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Usuario;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UsuarioDAO extends DAO<Usuario>{

    @Override
    public Class<Usuario> getEntityClass() {
        return Usuario.class;
    }
}
