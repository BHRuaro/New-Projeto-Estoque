package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Usuario;
import jakarta.enterprise.context.RequestScoped;
import org.glassfish.jaxb.core.v2.model.core.ID;

@RequestScoped
public class UsuarioDAO extends DAO<Usuario, ID>{

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
