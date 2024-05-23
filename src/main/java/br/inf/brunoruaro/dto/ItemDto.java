package br.inf.brunoruaro.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Integer itemId;
    private Integer fornecedorId;
    private String nome;
    private String descricao;
    private Float precoUnitario;
    private Integer quantidade;
    private String dataValidade;
    private Integer limiteMovimentacao;
    private Integer operadorId;
}
