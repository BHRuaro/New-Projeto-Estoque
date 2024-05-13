package br.inf.brunoruaro.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UsuarioDto {

    private Integer usuarioId;
    private String nome;
    private String email;
    private Long cpf;
    private OperadorDto operadorId;
}
