package br.inf.brunoruaro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@Table(name = "tipo_movimentacao")
public class TipoMovimentacao {

    @Column(name = "tipo_movimentacao_id")
    @Id
    private Integer tipoMovimentacaoId;

    @Column
    private String descricao;

    @OneToMany(mappedBy = "tipoMovimentacao")
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "tipoMovimentacao")
    private List<HistoricoMovimentacoes> historicoMovimentacoes;

    public TipoMovimentacao() {
    }

    public TipoMovimentacao(Integer tipoMovimentacaoId, String descricao) {
        this.tipoMovimentacaoId = tipoMovimentacaoId;
        this.descricao = descricao;
    }

    public Integer getTipoMovimentacaoId() {
        return tipoMovimentacaoId;
    }

    public void setTipoMovimentacaoId(Integer tipoMovimentacaoId) {
        this.tipoMovimentacaoId = tipoMovimentacaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoMovimentacao: " + tipoMovimentacaoId +
                " - " + descricao;
    }
}