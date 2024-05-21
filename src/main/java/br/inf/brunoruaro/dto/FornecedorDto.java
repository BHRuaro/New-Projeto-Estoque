package br.inf.brunoruaro.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorDto {

    private Integer fornecedorId;
    private String nome;
    private Long cnpj;
    private Integer operadorId;
}
