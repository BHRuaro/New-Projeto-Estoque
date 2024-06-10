package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Usuario;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UsuarioDAO extends DAO<Usuario>{

    @Override
    public Class<Usuario> getEntityClass() {
        return Usuario.class;
    }

    public Usuario findByCpf(Long cpf) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.cpf = :cpf", Usuario.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
