package br.inf.brunoruaro.dto;

import lombok.*;

import java.sql.Date;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistoricoCadastroDto {

    private Integer historicoCadId;
    private Integer itemId;
    private Integer usuarioId;
    private Integer operadorId;
    private Integer fornecedorId;
    private Date data;
}
