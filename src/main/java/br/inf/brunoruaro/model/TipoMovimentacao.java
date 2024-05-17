package br.inf.brunoruaro.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tipo_movimentacao")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Getter
public class TipoMovimentacao {

    @Column(name = "tipo_movimentacao_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_tipo_movimentacao", sequenceName = "sequence_tipo_movimentacao")
    private Integer tipoMovimentacaoId;

    @Column
    private String descricao;

    @OneToMany(mappedBy = "tipoMovimentacao")
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "tipoMovimentacao")
    private List<HistoricoMovimentacoes> historicoMovimentacoes;
}