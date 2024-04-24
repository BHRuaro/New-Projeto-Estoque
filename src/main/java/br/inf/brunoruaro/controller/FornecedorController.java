package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Fornecedor;
import br.inf.brunoruaro.dao.FornecedorDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class FornecedorController {

    @Inject
    FornecedorDAO fornecedorDAO;
    @Inject
    HistoricoCadastrosController historicoCadastrosController;

    public Integer fornecedorCreate(Fornecedor fornecedor) throws ApiException {

        if(!validaCadastro(fornecedor)){
            throw new ApiException("Erro ao validar cadastro");
        } 

        try {
            fornecedorDAO.add(fornecedor);
            historicoCadastrosController.adicionaCadastro(fornecedor);
        }catch (Exception e){
            throw new ApiException("Erro ao adicionar fornecedor");
        }
        return fornecedor.getFornecedorId();
    }

    public Fornecedor fornecedorFind (Integer fornecedorId) throws ApiException {

        if (fornecedorId == null || fornecedorId <= 0){
            throw new ApiException("Informe um id de fornecedor válido");
        } else if (fornecedorDAO.find(fornecedorId) == null) {
            throw new ApiException("Fornecedor não encontrado");
        }

        try {
            return fornecedorDAO.find(fornecedorId);
        } catch (Exception e) {
            throw new ApiException("Erro ao buscar fornecedor");
        }
    }

    public void fornecedorRemove(Integer fornecedorId) throws ApiException{

        if (fornecedorId == null || fornecedorId <= 0){
            throw new ApiException("Informe um id de fornecedor válido");
        } else if (fornecedorDAO.find(fornecedorId) == null) {
            throw new ApiException("Fornecedor não encontrado");
        }
        try{
            Fornecedor fornecedor = fornecedorDAO.find(fornecedorId);
            fornecedorDAO.remove(fornecedor);
        }catch (Exception e){
            throw new ApiException("Erro ao remover fornecedor");
        }

    }

    public Fornecedor fornecedorUpdate(Fornecedor fornecedor) throws ApiException{

        if(!validaCadastro(fornecedor)){
            throw new ApiException("Erro ao validar cadastro");
        }

        try {
            return fornecedorDAO.update(fornecedor);
        } catch (Exception e) {
            throw new ApiException("Erro ao atualizar fornecedor");
        }
    }

    public List<Fornecedor> fornecedorList() throws ApiException{
        try {
            return fornecedorDAO.list();
        } catch (Exception e) {
            throw new ApiException("Erro ao listar fornecedores");
        }
    }

    private static boolean validaCadastro(Fornecedor fornecedor) throws ApiException {
        if (fornecedor.getNome() == null || fornecedor.getNome().isEmpty()) {
            throw new ApiException("Nome do fornecedor não pode ser vazio");
        }

        if (!validarCnpj(fornecedor.getCnpj())) {
            throw new ApiException("CNPJ do fornecedor inválido");
        }

        return true;
    }

    public static boolean validarCnpj(Long cnpj) {
        if (cnpj == null) {
            return false;
        }

        String cnpjStr = String.valueOf(cnpj);

        if (cnpjStr.length() != 14) {
            return false;
        }

        try {
            int soma = 0;
            int peso = 2;
            for (int i = 11; i >= 0; i--) {
                soma += Character.getNumericValue(cnpjStr.charAt(i)) * peso;
                peso = (peso == 9 ? 2 : peso + 1);
            }
            int digito1 = soma % 11 < 2 ? 0 : 11 - (soma % 11);

            soma = 0;
            peso = 2;
            for (int i = 12; i >= 0; i--) {
                soma += Character.getNumericValue(cnpjStr.charAt(i)) * peso;
                peso = (peso == 9 ? 2 : peso + 1);
            }
            int digito2 = soma % 11 < 2 ? 0 : 11 - (soma % 11);

            return Character.getNumericValue(cnpjStr.charAt(12)) == digito1 &&
                    Character.getNumericValue(cnpjStr.charAt(13)) == digito2;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
