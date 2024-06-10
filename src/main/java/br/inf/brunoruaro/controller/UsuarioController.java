package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.error.ApiException;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import br.inf.brunoruaro.dao.UsuarioDAO;
import br.inf.brunoruaro.model.Usuario;

@RequestScoped
public class UsuarioController extends CrudController<Usuario>{

    @Inject
    UsuarioDAO usuarioDAO;

    @Inject
    HistoricoCadastrosController historicoCadastrosController;

    @PostConstruct
    public void init() {
        this.dao = usuarioDAO;
    }

    @Override
    public Integer getId(Usuario entity) {
        return entity.getUsuarioId();
    }

    @Override
    public Integer create(Usuario usuario) throws ApiException {
        if(validaCadastro(usuario)){
            throw new ApiException("Erro ao validar cadastro");
        }
        try {
            usuarioDAO.add(usuario);
            historicoCadastrosController.adicionaCadastro(usuario);
        }catch (Exception e){
            throw new ApiException("Erro ao adicionar usuário");
        }

        return usuario.getUsuarioId();
    }

    @Override
    public Usuario update(Usuario usuario) throws ApiException {

        if(validaCadastro(usuario)){
            throw new ApiException("Erro ao validar cadastro");
        }

        try {
            return usuarioDAO.update(usuario);
        } catch (Exception e){
            throw new ApiException("Erro ao atualizar usuário");
        }
    }

    public Usuario findByCpf(Long cpf) throws ApiException {
        if (usuarioDAO.findByCpf(cpf) != null){
            return usuarioDAO.findByCpf(cpf);
        }else {
            throw new ApiException("Usuário não encontrado");
        }
    }

    public static boolean validaCadastro(Usuario usuario) throws ApiException{
        if(usuario.getNome() == null || usuario.getNome().isEmpty()){
            throw new ApiException("Nome do usuário não pode ser vazio");
        }

        if(!validarCPF(usuario.getCpf())){
            throw new ApiException("CPF do usuário inválido");
        }

        if(!validarEmail(usuario.getEmail())){
            throw new ApiException("Email do usuário inválido");
        }

        if(usuario.getOperador() == null){
            throw new ApiException("Informe um id de operador válido");
        }

        return false;
    }

    public static boolean validarCPF(Long cpf) {
        String cpfStr = String.valueOf(cpf);

        if (cpfStr.length() != 11) {
            return false;
        }

        if (cpfStr.matches("(.)\\1{10}")) {
            return false;
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(cpfStr.substring(i, i+1));
        }

        int soma1 = 0;
        int soma2 = 0;
        for (int i = 0; i < 9; i++) {
            soma1 += digitos[i] * (10 - i);
            soma2 += digitos[i] * (11 - i);
        }

        int digito1 = 11 - (soma1 % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        soma2 += digito1 * 2;
        int digito2 = 11 - (soma2 % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }

        return (digitos[9] == digito1 && digitos[10] == digito2);
    }

    public static boolean validarEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}
