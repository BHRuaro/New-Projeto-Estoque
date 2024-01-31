package br.inf.brunoruaro.model;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UsuarioDAO extends DAO<Usuario>{

    @Override
    public Class<Usuario> getEntityClass() {
        return Usuario.class;
    }

    public Usuario find(Integer id) {
        return super.find(id);
    }

    public void add(Usuario usuario) {
        super.add(usuario);
    }

    public void remove(Usuario usuario) {
        super.remove(usuario);
    }

    public Usuario update(Usuario usuario) {
        return super.update(usuario);
    }
}
