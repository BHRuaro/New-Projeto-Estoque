package br.inf.brunoruaro.dto;

import lombok.*;

import java.sql.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoMovimentacaoDto {

    private Integer historicoMovId;
    private Integer movimentacaoId;
    private Date data;
    private Integer tipoMovimentacaoId;
    private Integer operadorId;
    private Integer usuarioId;
    private Integer itemId;
    private Integer quantidade;
}
