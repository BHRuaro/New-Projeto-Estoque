package br.inf.brunoruaro.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Column(name = "item_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_itens", sequenceName = "sequence_item")
    private Integer itemId;

    @ManyToOne(cascade = CascadeType.DETACH)
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

    @OneToMany(mappedBy = "item")
    private List<Movimentacao> movimentacoes;

    @OneToMany(mappedBy = "item")
    private List<HistoricoCadastros> historicoCadastros;

    @OneToMany(mappedBy = "item")
    private List<HistoricoMovimentacoes> historicoMovimentacoes;

    public Item() {
    }

    public Item(Integer itemId, Fornecedor fornecedor, String nome, String descricao, Float precoUnitario, Integer quantidade, Date dataValidade) {
        this.itemId = itemId;
        this.fornecedor = fornecedor;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

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
