package br.inf.brunoruaro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import java.util.List;


@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Column(name = "fornecedor_id")
    @Id
    private Integer forncedorId;

    @Column
    private String nome;

    @Column
    private Long cnpj;

    @OneToMany(mappedBy = "fornecedor")
    private List<Item> itens;

    public Fornecedor() {
    }

    public Fornecedor(Integer forncedorId, String nome, Long cnpj) {
        this.forncedorId = forncedorId;
        this.nome = nome;
        this.cnpj = cnpj;
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
        return forncedorId;
    }

    public void setForncedorId(Integer forncedorId) {
        this.forncedorId = forncedorId;
    }

    @Override
    public String toString() {
        return "Fornecedor: " + forncedorId +
                ", nome: '" + nome +
                ", cnpj: " + cnpj;
    }
}