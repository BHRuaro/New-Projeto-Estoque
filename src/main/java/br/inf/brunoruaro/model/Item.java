package br.inf.brunoruaro.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "item")
@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Item {

    @Column(name = "item_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_itens", sequenceName = "sequence_item")
    private Integer itemId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fornecedor_id", referencedColumnName = "fornecedor_id")
    private Fornecedor fornecedor;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column(name = "preco_unitario")
    private Float precoUnitario;

    @Column(name = "quantidade_estoque")
    private Integer quantidade;

    @Column(name = "data_validade")
    private Date dataValidade;

    @Column(name = "limite_movimentacao")
    private Integer limiteMovimentacao;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @OneToMany(mappedBy = "item")
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "item")
    private List<HistoricoCadastros> historicoCadastros;

    @OneToMany(mappedBy = "item")
    private List<HistoricoMovimentacoes> historicoMovimentacoes;

    @Override
    public String toString() {
        return "Item: " + itemId +
                ", nome: '" + nome +
                ", descrição: '" + descricao +
                ", preço unitário: " + precoUnitario +
                ", quantidade: " + quantidade +
                ", data de validade: " + dataValidade;
    }
}
