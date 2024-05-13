package br.inf.brunoruaro.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OperadorDto {

    private Integer operadorId;
    private String nome;
}
