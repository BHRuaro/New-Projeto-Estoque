package br.inf.brunoruaro.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperadorDto {

    private Integer operadorId;
    private String nome;
    private String senha;
}
