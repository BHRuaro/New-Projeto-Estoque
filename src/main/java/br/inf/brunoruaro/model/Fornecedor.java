package br.inf.brunoruaro.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "fornecedor")
public class Fornecedor {


    @Column(name = "fornecedor_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_id_fornecedor", sequenceName = "sequence_fornecedor")
    private Integer fornecedorId;

    @Column
    private String nome;

    @Column
    private Long cnpj;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "operador_id", referencedColumnName = "operador_id")
    private Operador operador;

    @OneToOne(mappedBy = "fornecedor", cascade = CascadeType.REMOVE)
    private HistoricoCadastros historicoCadastros;

    @OneToMany(mappedBy = "fornecedor")
    private List<Item> itens;

    public Fornecedor() {
    }

    public Fornecedor(Integer fornecedorId, String nome, Long cnpj, Operador operador) {
        this.fornecedorId = fornecedorId;
        this.nome = nome;
        this.cnpj = cnpj;
        this.operador = operador;
    }

    public Integer getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Integer fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getForncedorId() {
        return fornecedorId;
    }

    public void setForncedorId(Integer fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return "Fornecedor: " + fornecedorId +
                ", nome: '" + nome +
                ", CNPJ: " + cnpj;
    }
}