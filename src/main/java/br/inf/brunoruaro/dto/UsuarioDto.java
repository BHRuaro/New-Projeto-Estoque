package br.inf.brunoruaro.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Integer usuarioId;
    private String nome;
    private String email;
    private Long cpf;
    private Integer operadorId;
}
