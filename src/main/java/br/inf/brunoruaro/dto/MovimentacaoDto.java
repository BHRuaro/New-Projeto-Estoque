package br.inf.brunoruaro.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoDto {

    private Integer movimentacaoId;
    private Integer itemId;
    private Integer quantidade;
    private Integer tipoMovimentacaoId;
    private Integer operadorId;
    private Integer usuarioId;
}