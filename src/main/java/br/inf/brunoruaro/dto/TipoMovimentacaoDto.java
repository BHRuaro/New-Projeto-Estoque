package br.inf.brunoruaro.dto;

import lombok.*;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TipoMovimentacaoDto {

    private Integer id;
    private String descricao;


}
