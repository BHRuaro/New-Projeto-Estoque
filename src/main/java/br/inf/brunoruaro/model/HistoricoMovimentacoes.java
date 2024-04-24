package br.inf.brunoruaro.model;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Table(name = "historico_movimentacoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoMovimentacoes {

    @Column(name = "historico_mov_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_historico_movimentacoes", sequenceName = "sequence_historico_movimentacoes")
    private Integer historicoMovId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "movimentacao_id", referencedColumnName = "movimentacao_id")
    private Movimentacao movimentacao;

    @Column(name = "data_movimentacao")
    private Date data;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tipo_movimentacao_id", referencedColumnName = "tipo_movimentacao_id")
    private TipoMovimentacao tipoMovimentacao;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;

    @Column(name = "quantidade_movimentada")
    private Integer quantidade;

    @Override
    public String toString() {
        return "HistoricoMovimentacoes{" +
                "historicoMovId=" + historicoMovId +
                ", movimentacao=" + movimentacao +
                ", data=" + data +
                ", tipoMovimentacao=" + tipoMovimentacao +
                ", operador=" + operador +
                ", usuario=" + usuario +
                ", item=" + item +
                ", quantidade=" + quantidade +
                '}';
    }
}
