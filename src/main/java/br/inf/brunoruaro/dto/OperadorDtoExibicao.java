package br.inf.brunoruaro.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperadorDtoExibicao {

    private Integer operadorId;
    private String nome;
    private String cargo;
    private Float salario;
}
