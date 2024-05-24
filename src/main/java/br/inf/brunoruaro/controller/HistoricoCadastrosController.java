package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.dao.HistoricoCadastrosDAO;
import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.*;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.sql.Date;

@RequestScoped
public class HistoricoCadastrosController extends CrudController<HistoricoCadastros>{

    @Inject
    HistoricoCadastrosDAO historicoCadastrosDAO;

    @PostConstruct
    public void init() {
        this.dao = historicoCadastrosDAO;
    }

    @Override
    public Integer getId(HistoricoCadastros entity) {
        return entity.getHistoricoCadId();
    }

    public void adicionaCadastro(Object object) throws ApiException {
        if(object instanceof Usuario usuario){

            insereUsuarioHistoricoCadastro(usuario);
        }else if(object instanceof Item item){

            insereItemHistoricoCadastro(item);
        } else if (object instanceof Fornecedor fornecedor){

            insereFornecedorHistoricoCadastro(fornecedor);
        } else{
            throw new RuntimeException("Erro ao adicionar cadastro");
        }
    }


    public void insereUsuarioHistoricoCadastro(Usuario usuario) throws ApiException {
        HistoricoCadastros historicoCadastros = new HistoricoCadastros();

        historicoCadastros.setUsuario(usuario);
        historicoCadastros.setData(new Date(System.currentTimeMillis()));
        historicoCadastros.setOperador(usuario.getOperador());

        create(historicoCadastros);
    }

    public void insereItemHistoricoCadastro(Item item) throws ApiException {
        HistoricoCadastros historicoCadastros = new HistoricoCadastros();

        historicoCadastros.setItem(item);
        historicoCadastros.setData(new Date(System.currentTimeMillis()));
        historicoCadastros.setOperador(item.getOperador());

        create(historicoCadastros);
    }

    public void insereFornecedorHistoricoCadastro(Fornecedor fornecedor) throws ApiException {
        HistoricoCadastros historicoCadastros = new HistoricoCadastros();

        historicoCadastros.setFornecedor(fornecedor);
        historicoCadastros.setData(new Date(System.currentTimeMillis()));
        historicoCadastros.setOperador(fornecedor.getOperador());

        create(historicoCadastros);
    }
}
